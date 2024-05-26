package innosage.crm.domain.content.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Converter
public class AttributeTypeConverter implements AttributeConverter<Object, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        JavaTimeModule module = new JavaTimeModule();
        objectMapper.registerModule(module);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }


    @Override
    public String convertToDatabaseColumn(Object attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting attribute to JSON string: " + e.getMessage(), e);
        }
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        try {
            if (isValidJson(dbData)) {
            JsonNode jsonNode = objectMapper.readTree(dbData);
            if (jsonNode.isInt()) {
                return jsonNode.intValue();
            } else if (jsonNode.isBoolean()) {
                return jsonNode.booleanValue();
            } else if (jsonNode.isTextual()) {
                // 날짜 문자열인지 확인
                String text = jsonNode.textValue();
                try {
                    return LocalDate.parse(text, DateTimeFormatter.ISO_LOCAL_DATE);
                } catch (Exception e) {
                    // 날짜 형식이 아니면 일반 텍스트로 처리
                    return text;
                }
            } else if (jsonNode.isArray()) {
                return objectMapper.convertValue(jsonNode, List.class);
            } else {
                throw new IllegalArgumentException("Unsupported JSON value: " + jsonNode);
            }
            } else {
                return dbData;
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading JSON string: " + e.getMessage(), e);
        }
    }

    private boolean isValidJson(String dbData) {
        try {
            objectMapper.readTree(dbData);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}


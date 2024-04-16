# CRM-BE

## 브랜치 네이밍

1) main branch, develop branch

main와 develop 브랜치는 본래 이름 그대로 사용

2) feature branch

feature/기능요약 형식. ex) feature/login

## 커밋 메시지 컨벤션

<aside>
✅

### 1. 커밋 유형 지정

- 커밋 유형은 영어 대문자로 작성하기
    
    
    | 커밋 유형 | 의미 |
    | --- | --- |
    | Feat | 새로운 기능 추가 |
    | Fix | 버그 수정 |
    | Docs | 문서 수정 |
    | Style | 코드 formatting, 세미콜론 누락, 코드 자체의 변경이 없는 경우 |
    | Refactor | 코드 리팩토링 |
    | Test | 테스트 코드, 리팩토링 테스트 코드 추가 |
    | Chore | 패키지 매니저 수정, 그 외 기타 수정 ex) .gitignore |
    | Design | CSS 등 사용자 UI 디자인 변경 |
    | Comment | 필요한 주석 추가 및 변경 |
    | Rename | 파일 또는 폴더 명을 수정하거나 옮기는 작업만인 경우 |
    | Remove | 파일을 삭제하는 작업만 수행한 경우 |
    | !BREAKING CHANGE | 커다란 API 변경의 경우 |
    | !HOTFIX | 급하게 치명적인 버그를 고쳐야 하는 경우 |

### 2. 제목과 본문을 빈행으로 분리

- 커밋 유형 이후 제목과 본문은 한글로 작성하여 내용이 잘 전달될 수 있도록 할 것
- 본문에는 변경한 내용과 이유 설명 (어떻게보다는 무엇 & 왜를 설명)

### 3. 제목 첫 글자는 대문자로, 끝에는 `.` 금지

### 4. 제목은 영문 기준 50자 이내로 할 것

### 5. 자신의 코드가 직관적으로 바로 파악할 수 있다고 생각하지 말자

### 6. 여러가지 항목이 있다면 글머리 기호를 통해 가독성 높이기

```
- 변경 내용 1
- 변경 내용 2
- 변경 내용 3
```

</aside>
## 디렉토리 구조

### ✅ 도메인형 디렉터리 구조
```
com
 ㄴ innosage
     ㄴ crm
         ㄴ domain
         |   ㄴ user
         |   |   ㄴ controller
         |   |   ㄴ dto
         |   |   ㄴ entity
         |   |   ㄴ service
         |   |   ㄴ repository
         |   |   ㄴ exception
         |   ㄴ sheet
         |   |   ㄴ controller
         |   |   ㄴ dto
         |   |   ㄴ entity
         |   |   ㄴ service
         |   |   ㄴ repository
         |   |   ㄴ exception
         |   ...
         ㄴ global
             ㄴ auth
             ㄴ common
             ㄴ config
             ㄴ exception
             ㄴ infra
             ㄴ util
```

## ☑️ 코드 컨벤션

<aside>
<img src="https://cdn-icons-png.flaticon.com/512/7350/7350737.png" alt="https://cdn-icons-png.flaticon.com/512/7350/7350737.png" width="40px" /> **문자열을 처리할 때는 쌍따옴표를 사용하도록 합니다.**

</aside>

<aside>
<img src="https://cdn-icons-png.flaticon.com/512/7500/7500264.png" alt="https://cdn-icons-png.flaticon.com/512/7500/7500264.png" width="40px" /> **문장이 종료될 때는 세미콜론을 붙여줍니다.**

</aside>

<aside>
🐫 **함수명, 변수명은 카멜케이스로 작성합니다.**

</aside>

<aside>
☝ **가독성을 위해 한 줄에 하나의 문장만 작성합니다.**

</aside>

<aside>
<img src="https://cdn-icons-png.flaticon.com/512/3602/3602241.png" alt="https://cdn-icons-png.flaticon.com/512/3602/3602241.png" width="40px" /> **주석은 설명하려는 구문에 맞춰 들여쓰기 합니다.**

```jsx
// Good
function someFunction() {
  ...

  // statement에 관한 주석
  statements
}
```

</aside>

<aside>
<img src="https://cdn-icons-png.flaticon.com/512/3978/3978575.png" alt="https://cdn-icons-png.flaticon.com/512/3978/3978575.png" width="40px" /> **연산자 사이에는 공백을 추가하여 가독성을 높입니다.**

```jsx
a+b+c+d // bad
a + b + c + d // good
```

</aside>

<aside>
☝ **콤마 다음에 값이 올 경우 공백을 추가하여 가독성을 높입니다.**

```jsx
var arr = [1,2,3,4]; //bad
var arr = [1, 2, 3, 4]; //good
```

</aside>

<aside>
🔠 생성자 함수명의 맨 앞글자는 대문자로 합니다.

```java
public void Person(){}
```

</aside>

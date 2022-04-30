# BookCheck
읽은 책을 기록하는 앱

## 개발 이유
문학(800)만 읽는 것 같아, 다양한 분야의 책을 읽고 싶었다. 십진분류법에 따라 통계를 내주어 평소 내가 어떤 분야의 책을 읽는지 확인을 하고 싶어 만든 앱이다.

## 기능
- C : 읽은 책 등록
- R : 읽은 책 조회
- U : 읽은 책 수정 (TO DO) 
- D : 읽은 책 삭제 (TO DO)

## 사용한 Open API
- [네이버 오픈 API](https://developers.naver.com/docs/search/book/) : 2022년 2월 19일 승인 완료!   
  - 책의 표지를 보여주기 위해 해당 api 추가 
- [국립 중앙도서관](https://www.nl.go.kr/NL/contents/N31101030700.do) : 2022년 2월 8일 승인 완료! 
  - 응답 결과로 카테고리를 받을 수 있어서 선택한 api

## 사용 라이브러리
- Retrofit2
- Moshi
- Okhttp3
- RxJava3
- RxAndroid
- [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart) (document: https://weeklycoding.com/mpandroidchart-documentation/)


## 프로젝트를 통해 배운점
- 공공API를 사용하기 위해서는 신청을 해야한다.
- api를 사용하기 위한 key를 발급 받았을 때, githuhb에 해당 키가 노출되지 않도록 코드를 작성하기 위해서는 `local.properties`를 사용한다. 
- Retrofit2를 사용하여 API 사용하는 방법을 배웠다.

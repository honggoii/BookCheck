# BookCheck
읽은 책을 기록하는 앱

<p align="center">
  <img src="https://user-images.githubusercontent.com/46019755/184641306-f114da8b-c30a-4b74-8d68-ff94c25b619d.png" width="23%"/>
  <img src="https://user-images.githubusercontent.com/46019755/184641310-07700bfa-c2eb-448a-8381-19c42dfcb342.png" width="23%"/>
  <img src="https://user-images.githubusercontent.com/46019755/184641316-742146ec-9cd1-47ed-a9b8-83559eaa71f1.png" width="23%"/>
  <img src="https://user-images.githubusercontent.com/46019755/184641322-cfa9f92a-1c22-4eae-aae6-0a95f5cb794b.png" width="23%"/>
</p>

## 개발 이유
문학(800)만 읽는 것 같아, 다양한 분야의 책을 읽고 싶었다. 십진분류법에 따라 통계를 내주어 평소 내가 어떤 분야의 책을 읽는지 확인을 하고 싶어 만든 안드로이드 앱.

## 기능
- C : 읽은 책 등록
- R : 읽은 책 조회
- D : 읽은 책 삭제 (@todo)

## 사용한 Open API
- [네이버 오픈 API](https://developers.naver.com/docs/search/book/)
  - 책의 표지를 보여주기 위해 해당 api 추가 
- [국립 중앙도서관](https://www.nl.go.kr/NL/contents/N31101030700.do)
  - 응답 결과로 카테고리를 받을 수 있어서 사용한 api

## 사용 라이브러리
- Jetpack
  - ViewModel
  - LiveData
  - RecyclerView
  - ConstraintLayout
  - ViewPager2
  - Room

- Retrofit2 (Network)
- Moshi
- Glide
- [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart) (document: https://weeklycoding.com/mpandroidchart-documentation/)

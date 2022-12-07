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
- U : 읽은 책 수정 (@todo)
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

## 아키텍처

<img width="536" alt="스크린샷 2022-05-10 오전 12 21 12" src="https://user-images.githubusercontent.com/46019755/167442599-01632f5b-9e17-47d8-b7ba-a059486d8ee7.png">

## 프로젝트 구조      

```
├──── BookCheckApplication.kt
|
├──── adpater
|  ├────── BookAdapter.kt               // 책 검색 리사이클러뷰에서 사용하는 어댑터
|  ├────── MyBookAdapter.kt             // 읽은 책 리사이클러뷰에서 사용하는 어댑터  
|  └────── TabPagerAdapter.kt           //  ViewPager에서 사용하는 어댑터 
|
├──── data
|  ├────── Book.kt                     // 네이버 도서 데이터   
|  └────── BookCode.kt                 // 국립 중앙도서관 데이터   
|
├──── database
|  ├────── Code.kt                     // 코드 분류별 개수 테이블 정의      
|  ├────── MyBook.kt                   // 읽은 책 데이터베이스 테이블 정의
|  ├────── MyBookDao.kt                // 데이터베이스를 사용하기 위한 쿼리 작성  
|  └────── MyBookDatabase.kt           // 데이터베이스 
|
├────network
|  ├────── BookSearchApiService.kt     // 네이버 도서 검색 API와 국립 중앙 도서관 API를 사용하기 위한 레트로핏 설정 인터페이스 
|  ├────── BookIsbnResponse.kt         // 국립 중앙도서관 API 응답 결과
|  └────── SearchResponse.kt           // 네이버 도서 검색 API 응답 결과 
|
├──── ui
|  ├────── BookDialog.kt               // 커스텀 다이얼로그
|  ├────── ChartFragment.kt            // 십진분류법에 따른 차트 탭 화면  
|  ├────── MainActivity.kt             // 3개의 Fragment를 담을 액티비티    
|  ├────── MainFragment.kt             // 책 검색 탭 화면
|  └────── ReadBookFragment.kt         // 읽은 책 탭 화면  
|       
└──── viewmodel
   └─ BookViewModel.kt
```


## 프로젝트를 통해 배운점
- 공공API를 사용하기 위해서는 신청을 해야한다.
- api를 사용하기 위한 key를 발급 받았을 때, githuhb에 해당 키가 노출되지 않도록 코드를 작성하기 위해서는 `local.properties`를 사용한다. 
- Retrofit2를 사용하여 API 사용하는 방법을 배웠다.
- Room을 사용하여 로컬 데이터베이스를 사용하는 방법을 배웠다.

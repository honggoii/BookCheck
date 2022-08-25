# BookCheck
읽은 책을 기록하는 앱


<img src="https://user-images.githubusercontent.com/46019755/184641306-f114da8b-c30a-4b74-8d68-ff94c25b619d.png" width="30%"/>
<img src="https://user-images.githubusercontent.com/46019755/184641310-07700bfa-c2eb-448a-8381-19c42dfcb342.png" width="30%"/>
<img src="https://user-images.githubusercontent.com/46019755/184641316-742146ec-9cd1-47ed-a9b8-83559eaa71f1.png" width="30%"/>
<img src="https://user-images.githubusercontent.com/46019755/184641322-cfa9f92a-1c22-4eae-aae6-0a95f5cb794b.png" width="30%"/>


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
ㄴ ui    
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ BookDialog : 커스텀 다이얼로그    
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ MainActivity : 3개의 Fragment를 담을 액티비티    
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ MainFragment : 책 검색 탭 화면    
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ ChartFragment : 십진분류법에 따른 차트 탭 화면    
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ ReadBookFragment : 읽은 책 택 화면    
ㄴ adapter    
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ TabPagerAdapter : ViewPager에서 사용하는 어댑터     
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ BookAdapter : 책 검색 리사이클러뷰에서 사용하는 어댑터     
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ MyBookAdapter : 읽은 책 리사이클러뷰에서 사용하는 어댑터     
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ BookAdapter : 책 검색 리사이클러뷰에서 사용하는 어댑터      
ㄴ network   
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ BookSearchApiService : 네이버 도서 검색 API와 국립 중앙 도서관 API를 사용하기 위한 레트로핏 설정 인터페이스    
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ SearchResponse : 네이버 도서 검색 API 응답 결과      
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ BookIsbnResponse : 국립 중앙도서관 API 응답 결과      
ㄴ database        
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ Code : 코드 분류별 개수 테이블 정의      
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ MyBook : 읽은 책 데이터베이스 테이블 정의    
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ MyBookDao : 데이터베이스를 사용하기 위한 쿼리 작성    
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ MyBookDatabase : 데이터베이스
ㄴ data     
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ Book : 네이버 도서 데이터      
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ BookCode : 국립 중앙도서관 데이터     
ㄴ viewmodel    
&nbsp;&nbsp;&nbsp;&nbsp;ㄴ BookViewModel    
-- BookCheckApplication
    

## 프로젝트를 통해 배운점
- 공공API를 사용하기 위해서는 신청을 해야한다.
- api를 사용하기 위한 key를 발급 받았을 때, githuhb에 해당 키가 노출되지 않도록 코드를 작성하기 위해서는 `local.properties`를 사용한다. 
- Retrofit2를 사용하여 API 사용하는 방법을 배웠다.
- Room을 사용하여 로컬 데이터베이스를 사용하는 방법을 배웠다.

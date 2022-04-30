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
- [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart)

## 프로젝트 구조
ㄴ acitivty
    ㄴ MainActivity : 3개의 Fragment를 담을 액티비티
ㄴ adapter
    ㄴ BookAdapter : 책 검색 리사이클러뷰에서 사용하는 어댑터
    ㄴ MyBookAdapter : 읽은 책 리사이클러뷰에서 사용하는 어댑터
    ㄴ TabPagerAdapter : ViewPager에서 사용하는 어댑터
ㄴ api
    ㄴ CommonAPI : 네이버 도서 검색 API
    ㄴ MyBookAPI : 국립 중앙 도서관 API
ㄴ dao
    ㄴ BookDao : 데이터베이스를 사용하기 위한 쿼리 작성
ㄴ Database
    ㄴ BookDatabase : Room 사용
ㄴ entity
    ㄴ MyBook : 데이터베이스 테이블 정의
ㄴ fragment
    ㄴ ListFragment : 읽은 책 탭 화면
    ㄴ MainFragment : 책 검색 탭 화면
    ㄴ ResultFragment : 책 분류 탭 화면
ㄴ model
    ㄴ BookModel : 네이버 도서 검색 API Response
    ㄴ MyBookModel : 국립 중앙 도서관 검색 API Response
    ㄴ MyBookResponse : 국립 중앙도서관 API Response
    ㄴ SearchResponse : 네이버 도서 검색 API Response
ㄴ Repository
ㄴ viewmodel
    ㄴ BookViewModel 
    ㄴ BookViewModelFactory
- BookAPI : retrofit2 세팅
- BookDialog : 팝업창
    


## 프로젝트를 통해 배운점
- 공공API를 사용하기 위해서는 신청을 해야한다.
- api를 사용하기 위한 key를 발급 받았을 때, githuhb에 해당 키가 노출되지 않도록 코드를 작성하기 위해서는 `local.properties`를 사용한다. 
- Retrofit2를 사용하여 API 사용하는 방법을 배웠다.

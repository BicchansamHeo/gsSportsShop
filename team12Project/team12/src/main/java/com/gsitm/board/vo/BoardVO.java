/**
 * @programName : BoardVO.java
 * @author : 강혜정
 * @date : 2018. 6. 17.
 * @function : boardVO java 파일
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 강혜정	2018-06-17 초안작성(게시글)
 * 강혜정  2018-06-19 데이터 추가(공지사항 관련 )
 */


package com.gsitm.board.vo;

/**
 * @author : 강혜정
 * @programName : BoardVO.java
 * @date : 2018. 6. 15.
 * @function : 커뮤니티 VO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 강혜정	 2018-06-15	  초안 작성
 */
public class BoardVO {
    private String boardTitle = "";         /* 게시글 이름         */
    private String writer = "";             /* 작성자             */
    private String content = "";            /* 게시글         	    */
    private String dates = "";              /* 날짜               */

    private String noticeTitle = "";        /* 공지사항 제목       */
    private String noticeContent = "";      /* 내용               */
    private String noticeDate = "";         /* 날짜               */


    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(String noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }


    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return dates;
    }

    public void setDate(String date) {
        this.dates = date;
    }

}

package com.gsitm.board.mapper;

import com.gsitm.board.vo.BoardVO;

import java.util.List;

/**
 * @author : 강혜정
 * @programName : BoardMapper.java
 * @date : 2018. 6. 15.
 * @function : 커뮤니티 Mapper
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 강혜정	 2018-06-15	  초안 작성
 */
public interface BoardMapper {

    /**
     * @methodName : readList
     * @author     : 강혜정
     * @date       : 2018. 6. 16.
     * @function   : 게시판 전체 불러오기
     */
    List<BoardVO> readList(BoardVO vo);

    /**
     * @methodName : readNoticeList
     * @author : 강혜정
     * @date : 2018. 6. 16.
     * @function : 공지 리스트
     */
    List<BoardVO> readNoticeList(BoardVO vo);

    /**
     * @methodName : read
     * @author : 강혜정
     * @date : 2018. 6. 16.
     * @function : 게시판 불러오기
     */
    BoardVO read(BoardVO vo);

    /**
     * @methodName : writeNotice
     * @author : 강혜정
     * @date : 2018. 6. 16.
     * @function : 공지 작성
     */
    void writeNotice(BoardVO boardVO);

}

package com.gsitm.board.service;

import com.gsitm.board.dao.BoardDao;
import com.gsitm.board.vo.BoardVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : 강혜정
 * @programName : BoardService.java
 * @date : 2018. 6. 15.
 * @function : 커뮤니티 service
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 강혜정	 2018-06-15	  초안 작성
 */
@Service
public class BoardService {

    @Resource(name = "boardDao")
    private BoardDao BoardDao;

    /**
     * @methodName : readList
     * @author : 강혜정
     * @date : 2018. 6. 16.
     * @function : 게시판 전체 불러오기
     */
    public List<BoardVO> readList(BoardVO boardVO) {

        List<BoardVO> resultList = BoardDao.readList(boardVO);
        return resultList;
    }

    /**
     * @methodName : readNoticeList
     * @author : 강혜정
     * @date : 2018. 6. 16.
     * @function : 공지 리스트
     */
    public List<BoardVO> readNoticeList(BoardVO boardVO) {

        List<BoardVO> resultList = BoardDao.readNoticeList(boardVO);
        return resultList;
    }

    /**
     * @methodName : read
     * @author : 강혜정
     * @date : 2018. 6. 16.
     * @function : 게시판 불러오기
     */
    public BoardVO read(BoardVO boardVO) {
        BoardVO result = BoardDao.read(boardVO);
        return result;
    }

    /**
     * @methodName : writeNotice
     * @author : 강혜정
     * @date : 2018. 6. 16.
     * @function : 공지 작성
     */
    public void writeNotice(BoardVO boardVO) {

        BoardDao.writeNotice(boardVO);
    }

}
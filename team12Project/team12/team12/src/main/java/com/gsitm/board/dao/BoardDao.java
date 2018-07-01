package com.gsitm.board.dao;

import com.gsitm.board.mapper.BoardMapper;
import com.gsitm.board.vo.BoardVO;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : 강혜정
 * @programName : BoardDao.java
 * @date : 2018. 6. 15.
 * @function : 커뮤니티 DAO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 강혜정	 2018-06-15	  초안 작성
 */
@Repository(value = "boardDao")
public class BoardDao {
    private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);

    @Autowired
    protected SqlSession sqlSession;

    /**
     * @methodName : read
     * @author : 강혜정
     * @date : 2018. 6. 16.
     * @function : 게시판 불러오기
     */
    public BoardVO read(BoardVO boardVO) {
        BoardVO vo = null;
        try {
            BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
            vo = boardMapper.read(boardVO);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return vo;
    }

    /**
     * @methodName : readList
     * @author : 강혜정
     * @date : 2018. 6. 16.
     * @function : 게시판 전체 불러오기
     */
    public List<BoardVO> readList(BoardVO boardVO) {
        List<BoardVO> list = null;
        try {
            BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
            list = boardMapper.readList(boardVO);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @methodName : readNoticeList
     * @author : 강혜정
     * @date : 2018. 6. 16.
     * @function : 공지 리스트
     */
    public List<BoardVO> readNoticeList(BoardVO boardVO) {
        List<BoardVO> list = null;
        try {
            BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
            list = boardMapper.readNoticeList(boardVO);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @methodName : writeNotice
     * @author : 강혜정
     * @date : 2018. 6. 16.
     * @function : 공지 작성
     */
    public void writeNotice(BoardVO boardVO) {
        try {
            BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
            boardMapper.writeNotice(boardVO);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return;
    }
}


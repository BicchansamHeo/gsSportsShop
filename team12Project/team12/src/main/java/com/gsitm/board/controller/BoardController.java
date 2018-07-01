package com.gsitm.board.controller;

import com.gsitm.board.service.BoardService;
import com.gsitm.board.vo.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;


/**
 * @author : 강혜정
 * @programName : BoardController.java
 * @date : 2018. 6. 15.
 * @function : 커뮤니티 메뉴
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 강혜정	 2018-06-15	  초안 작성
 */
@Controller
public class BoardController {

    @Resource(name = "boardService")
    private BoardService boardService;

    /**
     * @methodName : Info
     * @author : 강혜정
     * @date : 2018. 6. 16.
     * @function : 게시판 불러오기
     */
    @RequestMapping(value = "/board.do", method = RequestMethod.GET)
    public ModelAndView Info(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param, ModelAndView model, BoardVO boardVO) throws Exception {

        List<BoardVO> boardList = boardService.readList(boardVO);
        List<BoardVO> noticeList = boardService.readNoticeList(boardVO);
        model.addObject("boardList", boardList);
        model.addObject("BoardVO", boardVO);
        model.addObject("noticeList", noticeList);
        model.setViewName("/boardList");
        return model;
    }

    /**
     * @methodName : boardDetail
     * @author : 강혜정
     * @date : 2018. 6. 20.
     * @function : 개발자 목록
     */
    @RequestMapping(value = "/developer.do", method = RequestMethod.GET)
    public ModelAndView team(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param, ModelAndView model) throws Exception {


        model.setViewName("/developer");
        return model;
    }
    /**
     * @methodName : boardDetail
     * @author : 강혜정
     * @date : 2018. 6. 16.
     * @function : 게시판 상세보기
     */
    @RequestMapping(value = "/boardDetail.do", method = RequestMethod.POST)
    public String boardDetail(Model model, BoardVO boardVO) throws Exception {
        BoardVO boardModel = boardService.read(boardVO);
        model.addAttribute("BoardVO", boardModel);
        return "/board";
    }

    /**
     * @methodName : noticeWrite
     * @author : 강혜정
     * @date : 2018. 6. 17.
     * @function : 공지 등록 페이지로 이동
     */
    @RequestMapping(value = "/writeNotice.do", method = RequestMethod.GET)
    public String noticeWrite(BoardVO boardVO) {

        return "/writeNotice";
    }

    /**
     * @methodName : noticeWrite
     * @author : 강혜정
     * @date : 2018. 6. 17.
     * @function : 공지 등록
     */
    @RequestMapping(value = "/writeNotice.do", method = RequestMethod.POST)
    public String noticeWrite(Model model, BoardVO boardVO) throws Exception {

        boardService.writeNotice(boardVO);

        return "/writeNotice";
    }

    /**
     * @methodName : boardDetail2
     * @author : 강혜정
     * @date : 2018. 6. 17.
     * @function : 공지 상세
     */
    @RequestMapping(value = "/boardDetail2.do", method = RequestMethod.GET)
    public ModelAndView boardDetail2(ModelAndView mv, BoardVO boardVO) throws Exception {
        BoardVO boardModel = boardService.read(boardVO);

        mv.addObject("BoardVO", boardModel);
        mv.setViewName("/board");

        return mv;
    }


}

package com.gsitm.roommanage.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.roommanage.service.ManageService;
import com.gsitm.roommanage.vo.AddFixVO;
import com.gsitm.roommanage.vo.ConfVO;
import com.gsitm.roommanage.vo.CountVO;
import com.gsitm.roommanage.vo.FixVO;
import com.gsitm.roommanage.vo.GetConfNameVO;
import com.gsitm.roommanage.vo.GetFixVO;
import com.gsitm.roommanage.vo.ImgVO;
import com.gsitm.roommanage.vo.PagingSiteVO;
import com.gsitm.roommanage.vo.PagingVO;
import com.gsitm.roommanage.vo.SiteVO;
import com.gsitm.roommanage.vo.UdConfVO;
/**
 * @author : 조현우
 * @programName : ManageController.java
 * @date : 2018-06-08
 * @function : 관리 컨트롤러
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 조현우	   06-08	 초안 작성
 * 조현우	   06-09   회의실/교육실 등록 기본 폼 작성
 * 조현우         06-11 등록에 필요한 정보 조회 컨트롤러 작성
 * 조현우         06-12 건물 등록 기본 폼 작성 및 등록 컨트롤러 작성
 * 조현우         06-13 건물 정보와 연동시켜 등록 폼 자동 작성 코드 작성
 * 조현우	   06-15  이미지 업로드 코드 작성
 * 조현우         06-16 건물 및 회의실/교육실 업데이트 컨트롤러 작성
 * 조현우         06-18 건물 및 회의실/교육실 삭제 컨트롤러 작성 및 회의실 리스트 조회 화면 작성
 * 조현우         06-20 회의실/교육실/건물 리스트 조회 페이징 및 상세보기 화면뿌려주기 작성
 * 조현우	   06-21  최종 점검 및 주석 점검 및 추가
 */
@Controller
public class ManageController {

	@Resource(name = "manageService")
	private ManageService manageService;

// ---------------------------------회의실 CRUD--------------------------------------------------------------------
	// 회의실 조회
	@RequestMapping(value = "/searchConf.do", method = RequestMethod.GET)
	public ModelAndView searchConference(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, ConfVO confVO) throws Exception {
		String roomKind = "conference";
		confVO.setRoomKind(roomKind);
		List<ConfVO> confList = manageService.readList2(confVO);
		mv.addObject("index", 1);
		mv.addObject("confList", confList);
		mv.setViewName("/confSearch");
		return mv;
	}
	// 교육실 조회
	@RequestMapping(value = "/searchEdu.do", method = RequestMethod.GET)
	public ModelAndView searchEdu(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, ConfVO confVO) throws Exception {
		String roomKind = "education";
		confVO.setRoomKind(roomKind);
		List<ConfVO> eduList = manageService.readList2(confVO);
		mv.addObject("index", 1);
		mv.addObject("eduList", eduList);
		mv.setViewName("/eduSearch");
		return mv;
	}
	// 건물 조회
	@RequestMapping(value = "/searchBuild.do", method = RequestMethod.GET)
	public ModelAndView searchBuild(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, SiteVO siteVO) throws Exception {
		
		List<SiteVO> buildList = manageService.selectList(siteVO);
		mv.addObject("index", 1);
		mv.addObject("buildList", buildList);
		mv.setViewName("/buildSearch");
		return mv;
	}
	@RequestMapping(value = "/searchMain.do", method = RequestMethod.GET)
	public ModelAndView searchMain(HttpServletRequest request, HttpServletResponse response,
																 HashMap<String, String> param, ModelAndView mv, ConfVO confVO) {

		//회의실인지 교육실인지 음성인식 후 코드 선택
		String code = "0";
		if (request.getParameter("code") != null) {
			code = request.getParameter("code");
		}
		mv.addObject("code", code);
		mv.addObject("index", 1);
		mv.setViewName("/searchMain");
		return mv;
	}
	// 데이터 조회
	@RequestMapping(value = "/addConf.do", method = RequestMethod.GET)
	public ModelAndView selectInfo(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, CountVO countVO, SiteVO siteVO, FixVO fixVO)
			throws Exception {
		// 건물 테이블 조회
		List<SiteVO> selectList = manageService.selectList(siteVO);
		// 기자재 테이블 조회
		List<FixVO> fixList = manageService.fixList(fixVO);
		// 카운트 조회
		List<CountVO> roomCnt = manageService.roomCount(countVO);

		String roomSeq = manageService.getRoomNo();

		mv.addObject("fixList", fixList);
		mv.addObject("selectList", selectList);
		mv.addObject("roomCount", roomCnt);
		mv.addObject("roomSeq", roomSeq);
		mv.setViewName("/addConference");
		return mv;
	}

	// 회의실/교육실 추가 페이지 데이터 컨트롤
	@RequestMapping(value = "/addConf.do", method = RequestMethod.POST)
	public ModelAndView insertConference(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, ConfVO confVO, SiteVO siteVO, ImgVO imgVO,
			AddFixVO addFixVO, MultipartHttpServletRequest mtfRequest) throws Exception {
		// TB_MEETING_ROOM 추가
		String confName = request.getParameter("confName");
		String roomComm = request.getParameter("roomComm");
		String roomKind = request.getParameter("roomKind");
		String roomSize = request.getParameter("roomSize");
		String network = request.getParameter("network");
		String roomState = request.getParameter("roomState");
		int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
		int roomPrice = Integer.parseInt(request.getParameter("roomPrice"));
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		String roomNo = request.getParameter("roomSeq");
		String siteNo = request.getParameter("siteNo");
		String siteAddr = request.getParameter("siteAddr");
		
		confVO.setConfAddr(siteAddr);
		confVO.setSiteNo(siteNo);
		
		
		if(roomKind.equals("education")) {
			roomNo = roomNo.replace("R", "E");
			System.out.println("helo : " + roomNo);
			confVO.setRoomNo(roomNo);
		} else {
			confVO.setRoomNo(roomNo);
		}
		
		confVO.setConfName(confName);
		confVO.setRoomComm(roomComm);
		confVO.setRoomKind(roomKind);
		confVO.setRoomSize(roomSize);
		confVO.setNetwork(network);
		confVO.setMaxPeople(maxPeople);
		confVO.setRoomState(roomState);
		confVO.setRoomPrice(roomPrice);
		confVO.setLongitude(longitude);
		confVO.setLatitude(latitude);
		
		// 메인 이미지 추가
		List<MultipartFile> fileList = mtfRequest.getFiles("mainFile");
		String src = mtfRequest.getParameter("src");
		String path = "C:\\spring_workspace\\team12\\src\\main\\webapp\\invent-v1.0\\img\\" + src + "\\";
		String urlPath = "\\invent-v1.0\\img\\" + src + "\\";
		for (MultipartFile mf : fileList) {
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명
			long fileSize = mf.getSize(); // 파일 사이즈


			String safeFile = path + originFileName;
			confVO.setMainImgPath(urlPath + originFileName);
			try {
				if (!(new File(safeFile).exists())) {
					new File(safeFile).mkdirs();
					mf.transferTo(new File(safeFile));
				} else {
					System.out.println("존재합니다.");
					mf.transferTo(new File(safeFile));
				}

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 회의실/교육실 등록
		int confModel = manageService.insertConference(confVO);

		// 기자재 추가 갯수 받아오는 부분
		int cnt = Integer.parseInt(request.getParameter("cnt")) + 1;

		// 받아온 기자재 추가
		for (int k = 1; k < cnt; k++) {
			String fixName = request.getParameter("FN" + k);
			int quantity = Integer.parseInt(request.getParameter("QU" + k));
			String getFixNo = manageService.getFixNo(fixName);
			addFixVO.setFixNo (getFixNo);
			addFixVO.setQuantity(quantity);
			addFixVO.setRoomNo(roomNo);
			int addFixModel = manageService.insertFix(addFixVO);
		}
		
		// 상세정보 이미지 저장 부분
		List<MultipartFile> fileList2 = mtfRequest.getFiles("file");
		String src2 = mtfRequest.getParameter("src");
		String path2 = "C:\\spring_workspace\\team12\\src\\main\\webapp\\invent-v1.0\\img\\" + src + "\\";
		String urlPath2 = "\\invent-v1.0\\img\\" + src + "\\";
		for (MultipartFile mf : fileList2) {
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명
			long fileSize = mf.getSize(); // 파일 사이즈


			String safeFile = path2 + originFileName;
			imgVO.setRoomName(src2);
			imgVO.setImgPath(urlPath2 + originFileName);
			imgVO.setImgName(originFileName);
			imgVO.setRoomNo(roomNo);
			int imgModel = manageService.insertImg(imgVO);
			try {
				if (!(new File(safeFile).exists())) {
					new File(safeFile).mkdirs();
					mf.transferTo(new File(safeFile));
				} else {
					System.out.println("존재합니다.");
					mf.transferTo(new File(safeFile));
				}

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		mv.setViewName("/addConference");
		return mv;
	}

	// 기자재 리스트 조회
	@RequestMapping(value = "/searchFix.do", method = RequestMethod.GET)
	public ModelAndView searchFix(HttpServletRequest request, HttpServletResponse response,
																HashMap<String, String> param, ModelAndView mv, FixVO fixVO) {

		mv.setViewName("/addConference");
		return mv;
	}

	// 회의실/교육실 수정 페이지 (GET)
	@RequestMapping(value = "/confUpdate.do", method = RequestMethod.GET)
	public ModelAndView confUpdate(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, UdConfVO udConfVO, FixVO fixVO, CountVO countVO, ConfVO confVO, GetFixVO getFixVO) throws Exception {
		
		
		// 회의실/교육실 업데이트 부분
		List<ConfVO> confInfoList = manageService.readList(confVO);
		List<GetFixVO> getFixList = manageService.getFixList(getFixVO);
		
		List<FixVO> fixList = manageService.fixList(fixVO);
		// 카운트 조회
		List<CountVO> roomCnt = manageService.roomCount(countVO);

		String roomSeq = manageService.getRoomNo();
		
	
		mv.addObject("fixList", fixList);
		mv.addObject("roomCount", roomCnt);
		mv.addObject("roomSeq", roomSeq);
		mv.addObject("confInfoList", confInfoList);
		mv.addObject("getFixList", getFixList);
		mv.setViewName("/updateConference");
		return mv;
	}
	// 회의실/교육실 업데이트 정보 저장(POST)
	@RequestMapping(value = "/confUpdate.do", method = RequestMethod.POST)
	public ModelAndView confUpdateCT(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, UdConfVO udConfVO, FixVO fixVO
			, AddFixVO addFixVO, CountVO countVO, ImgVO imgVO, ConfVO confVO, GetFixVO getFixVO, MultipartHttpServletRequest mtfRequest) throws Exception {
		
		String roomNo = mtfRequest.getParameter("roomNo");
		String confName = mtfRequest.getParameter("confName");
		String roomComm = mtfRequest.getParameter("roomComm");
		int roomPrice = Integer.parseInt(mtfRequest.getParameter("roomPrice"));
		String network = mtfRequest.getParameter("network");
		String mainImgPath = mtfRequest.getParameter("mainImgPath");
		
		udConfVO.setRoomNo(roomNo);
		udConfVO.setConfName(confName);
		udConfVO.setRoomComm(roomComm);
		udConfVO.setRoomPrice(roomPrice);
		udConfVO.setNetwork(network);
		
		//메인 이미지 수정
		List<MultipartFile> fileList = mtfRequest.getFiles("mainFile");
		String src = mtfRequest.getParameter("src");
		String path = "C:\\spring_workspace\\team12\\src\\main\\webapp\\invent-v1.0\\img\\" + src + "\\";
		String urlPath = "\\invent-v1.0\\img\\" + src + "\\";
		for (MultipartFile mf : fileList) {
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명
			long fileSize = mf.getSize(); // 파일 사이즈


			String safeFile = path + originFileName;
			udConfVO.setMainImgPath(urlPath + originFileName);
			try {
				if (!(new File(safeFile).exists())) {
					new File(safeFile).mkdirs();
					mf.transferTo(new File(safeFile));
				} else {
					System.out.println("존재합니다.");
					mf.transferTo(new File(safeFile));
				}

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int updateConfInfo = manageService.updateConfInfo(udConfVO);
		
		// 기자재 추가 갯수 받아오는 부분
				int cnt = Integer.parseInt(request.getParameter("cnt")) + 1;
				// 받아온 기자재 추가
				for (int k = 1; k < cnt; k++) {
					String fixName = request.getParameter("FN" + k);
					int quantity = Integer.parseInt(request.getParameter("QU" + k));
					String getFixNo = manageService.getFixNo(fixName);
					addFixVO.setFixNo(getFixNo);
					addFixVO.setQuantity(quantity);
					addFixVO.setRoomNo(roomNo);
					int addFixModel = manageService.insertFix(addFixVO);
				}
				
		// 상세조회 이미지 수정
		List<MultipartFile> fileList2 = mtfRequest.getFiles("file");
		String src2 = mtfRequest.getParameter("src");
		String path2 = "C:\\spring_workspace\\team12\\src\\main\\webapp\\invent-v1.0\\img\\" + src + "\\";
		String urlPath2 = "\\invent-v1.0\\img\\" + src + "\\";
		for (MultipartFile mf : fileList2) {
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명
			long fileSize = mf.getSize(); // 파일 사이즈


			String safeFile = path2 + originFileName;
			imgVO.setRoomName(src2);
			imgVO.setImgPath(urlPath2 + originFileName);
			imgVO.setImgName(originFileName);
			imgVO.setRoomNo(roomNo);
			int imgModel = manageService.insertImg(imgVO);
			try {
				if (!(new File(safeFile).exists())) {
					new File(safeFile).mkdirs();
					mf.transferTo(new File(safeFile));
				} else {
					System.out.println("존재합니다.");
					mf.transferTo(new File(safeFile));
				}

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 기자재 추가업데이트 
		String[] arr = request.getParameterValues("updateFixName");
		String[] arr2 = request.getParameterValues("updateFixQuantity");
		String[] fixNoList = request.getParameterValues("updateFixNo");
		for(int i = 0; i < arr2.length; i++) {
			getFixVO.setFixName(arr[i]);
			getFixVO.setFixNo(fixNoList[i]);
			getFixVO.setQuantity(Integer.parseInt(arr2[i]));
			getFixVO.setRoomNo(roomNo);
			int updateUseFix = manageService.updateUseFix(getFixVO);
		}
		mv.setViewName("/updateConference");
		return mv;
	}
	
	// 회의실/교육실 삭제 
	@RequestMapping(value = "/deleteConf.do", method = RequestMethod.POST)
	public ModelAndView DeleteConf(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, SiteVO siteVO) throws Exception {
		String roomNo = request.getParameter("updateRoomNo");
		int deleteModel = manageService.deleteConf(roomNo);
		int deleteUseFix = manageService.deleteUseFix(roomNo);
		mv.setViewName("/addConference");
		return mv;
	}
// ---------------------------------건물(근무지CRUD)--------------------------------------------------------------------
	// 건물등록 페이지 이동
	@RequestMapping(value = "/addSite.do", method = RequestMethod.GET)
	public ModelAndView insertSite(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv) throws Exception {
		String siteSeq = manageService.getSiteNo();
		mv.addObject("siteSeq", siteSeq);
		mv.setViewName("/addSite");
		return mv;
	}

	// 건물 데이터 추가
	@RequestMapping(value = "/addSite.do", method = RequestMethod.POST)
	public ModelAndView insertSite(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, SiteVO siteVO) throws Exception {
		int confModel = manageService.insertSite(siteVO);
		mv.setViewName("/addSite");
		return mv;
	}

	// 건물 수정 페이지
	@RequestMapping(value = "/modifySite.do", method = RequestMethod.GET)
	public ModelAndView ModifySite(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, SiteVO siteVO) throws Exception {
		List<SiteVO> siteList = manageService.selectList(siteVO);
		mv.addObject("siteList", siteList);
		mv.setViewName("/modifySite");
		return mv;
	}

	// 건물 수정 컨트롤
	@RequestMapping(value = "/modifySite.do", method = RequestMethod.POST)
	public ModelAndView UpdateSite(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, SiteVO siteVO) throws Exception {
		int siteModel = manageService.updateSite(siteVO);
		mv.setViewName("/modifySite");
		return mv;
	}

	// 건물(근무지) 삭제
	@RequestMapping(value = "/deleteSite.do", method = RequestMethod.POST)
	public ModelAndView DeleteSite(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, SiteVO siteVO) throws Exception {
		String siteNo = request.getParameter("siteNo");
		int deleteModel = manageService.deleteSite(siteNo);

		mv.setViewName("/paging.do?index=1&roomkind=conference");
		return mv;
	}
// ---------------------------------페이징 관련----------------------------------------------------------------------------------------
	// 회의실 리스트 조회 페이징
	@RequestMapping(value = "/paging.do", method = RequestMethod.GET)
	public ModelAndView pagingConf(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, PagingVO pagingVO) throws Exception {
		// 선택한 인덱스 값
		int index = Integer.parseInt(request.getParameter("index"));
		// 화면에 뿌려지는 갯수
		int defaultNum = 3;
		
		int start = (((index-1)*defaultNum)+1);
		int end = index * defaultNum;
		int totalPages = 0;
		
		String roomKind = request.getParameter("roomkind");
		int count = manageService.getCount(roomKind);
		if((count%defaultNum)==0) {
			totalPages = count/defaultNum;
		} else {
			totalPages = (count/defaultNum) + 1;
		}
		
		pagingVO.setDefaultNum(end);
		pagingVO.setIndex(start);
		pagingVO.setRoomKind(roomKind);
		
		List<PagingVO> resultList = manageService.getConfList(pagingVO);
		mv.addObject("totalPg", totalPages);
		mv.addObject("index", index);
		mv.addObject("confList", resultList);
		mv.setViewName("/confSearch");
		return mv;
	}
	
	//교육실 리스트 페이징
	@RequestMapping(value = "/pagingEdu.do", method = RequestMethod.GET)
	public ModelAndView pagingEdu(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, PagingVO pagingVO) throws Exception {
		// 선택한 값
		int index = Integer.parseInt(request.getParameter("index"));
		// 화면에 뿌려질 갯수
		int defaultNum = 3;
		
		int start = (((index-1)*defaultNum)+1);
		int end = index * defaultNum;
		int totalPages = 0;
		
		String roomKind = request.getParameter("roomkind");
		int count = manageService.getCount(roomKind);
		if((count%defaultNum)==0) {
			totalPages = count/defaultNum;
		} else {
			totalPages = (count/defaultNum) + 1;
		}
		pagingVO.setDefaultNum(end);
		pagingVO.setIndex(start);
		pagingVO.setRoomKind(roomKind);
		List<PagingVO> resultList = manageService.getConfList(pagingVO);
		mv.addObject("totalPg", totalPages);
		mv.addObject("index", index);
		mv.addObject("eduList", resultList);
		mv.setViewName("/eduSearch");
		return mv;
	}
	// 건물 페이징 관련
	@RequestMapping(value = "/pagingBuild.do", method = RequestMethod.GET)
	public ModelAndView pagingSite(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, PagingSiteVO pagingSiteVO) throws Exception {
		// 선택한 인덱스 값
		int index = Integer.parseInt(request.getParameter("index"));
		// 갯수 
		int defaultNum = 3;
		
		int start = (((index-1)*defaultNum)+1);
		int end = index * defaultNum;
		int totalPages = 0;
		int count = manageService.getSiteCount();
		
		pagingSiteVO.setIndex(start);
		pagingSiteVO.setDefaultNum(end);
		List<PagingSiteVO> resultList = manageService.getSiteList(pagingSiteVO);		
		if((count%defaultNum)==0) {
			totalPages = count/defaultNum;
		} else {
			totalPages = (count/defaultNum) + 1;
		}
		mv.addObject("totalPg", totalPages);
		mv.addObject("index", index);
		mv.addObject("SiteList", resultList);
		mv.setViewName("/buildSearch");
		return mv;
	}
// ---------------------------------A jax 관련----------------------------------------------------------------------------------------

	// ajax 건물정보 받기
	@RequestMapping(value = "/getSiteLD.do", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getSiteLD(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, SiteVO siteVO) throws Exception {

		List<SiteVO> list = manageService.selectOption(siteVO);
		Map map = new HashMap();
		map.put("data", list);

		return new ModelAndView("jsonView", map);
	}
	// ajax 기존 회의실 정보 받기
	@RequestMapping(value = "/getConfInfo.do", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getConfInfo(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, ConfVO confVO) throws Exception {

		List<ConfVO> list = manageService.getConfInfo(confVO);
		Map map = new HashMap();
		map.put("data", list);

		return new ModelAndView("jsonView", map);
	}
	
	// ajax 회의실 주소 값 전달
	@RequestMapping(value = "/getConfAddr.do", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getConfAddr(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, SiteVO siteVO) throws Exception {

		List<SiteVO> result = manageService.getConfAddr(siteVO);
		System.out.println("result : " + result);
		Map map = new HashMap();
		map.put("data", result);

		return new ModelAndView("jsonView", map);
	}
	
	// ajax 기자재 정보 받기
	@RequestMapping(value = "/getFixList.do", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getfixList(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, FixVO fixVO) throws Exception {

		List<FixVO> list = manageService.fixList(fixVO);
		Map map = new HashMap();
		map.put("data", list);

		return new ModelAndView("jsonView", map);
	}
	// ajax 기존 기자재 정보 받기
	@RequestMapping(value = "/getUseFix.do", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getUseFix(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, GetFixVO getFixVO) throws Exception {

		List<GetFixVO> getFixList = manageService.getFixList(getFixVO);
		Map map = new HashMap();
		map.put("data", getFixList);

		return new ModelAndView("jsonView", map);
	}
	// ajax 기존 회의실 값 이름 정보 받기
	@RequestMapping(value = "/getConfName.do", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getConfName(HttpServletRequest request, HttpServletResponse response,
			HashMap<String, String> param, ModelAndView mv, GetConfNameVO getConfNameVO) throws Exception {
		List<GetConfNameVO> getConfName = manageService.getConfName(getConfNameVO);
		Map map = new HashMap();
		map.put("data", getConfName);

		return new ModelAndView("jsonView", map);
	}
}

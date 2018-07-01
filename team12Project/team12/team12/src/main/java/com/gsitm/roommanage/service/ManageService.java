package com.gsitm.roommanage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsitm.roommanage.manageDao.ManageDao;
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
 * 조현우	   06-09   회의실/교육실 등록 기본 폼 관련 서비스
 * 조현우         06-11 등록에 필요한 정보 조회 관련 서비스
 * 조현우         06-12 건물 등록 기본 폼 작성 및 등록 관련 서비스
 * 조현우         06-13 건물 정보와 연동시켜 등록 폼 자동 작성 코드 관련 서비스
 * 조현우	   06-15  이미지 업로드 코드 관련 서비스
 * 조현우         06-16 건물 및 회의실/교육실 업데이트 관련 서비스
 * 조현우         06-18 건물 및 회의실/교육실 삭제 컨트롤러 작성 및 회의실 리스트 조회 화면 관련 서비스
 * 조현우         06-20 회의실/교육실/건물 리스트 조회 페이징 및 상세보기 화면뿌려주기 관련 서비스
 * 조현우	   06-21  최종 점검 및 주석 점검 및 추가
 */
@Service
public class ManageService {
	
	@Resource(name="manageDao")
	private ManageDao manageDao;
//---------------------------------------회의실 관련-------------------------------------------------------------------
	// 회의실/교육실 추가
	public int insertConference(ConfVO confModel) throws Exception {
		int insertResult = manageDao.insertConference(confModel);
		return insertResult;
	}
	
	// 이미지 추가
	public int insertImg(ImgVO imgModel) throws Exception {
		int insertResult = manageDao.insertImg(imgModel);
		return insertResult;
	}
	
	// 회의실/교육실 조회
	public List<ConfVO> readList(ConfVO confModel) throws Exception{

		List<ConfVO> resultList = manageDao.readList(confModel);
		return resultList;
	}
	
	// 회의실/교육실 부가정보 조회
	public List<ConfVO> readList2(ConfVO confModel) throws Exception{

		List<ConfVO> resultList = manageDao.readList2(confModel);
		return resultList;
	}
	
	// 상세조회
	public ConfVO detailList(ConfVO confModel) throws Exception{

		ConfVO resultList = manageDao.detailList(confModel);
		return resultList;
	}
	// 상제이미지 조회
	public List<ImgVO> detailImgs(ImgVO imgs) throws Exception{

		List<ImgVO> resultList = manageDao.detailImgs(imgs);
		return resultList;
	}
	
	// 기자재 리스트 조회
	public List<FixVO> fixList(FixVO fixModel) throws Exception{

		List<FixVO> resultList = manageDao.fixList(fixModel);
		return resultList;
	}
	
	// 자재추가
	public int insertFix(AddFixVO addFixModel) throws Exception {
		int insertResult = manageDao.insertFix(addFixModel);
		return insertResult;
	}
	
	// 카운트 관련
	public List<CountVO> roomCount(CountVO countVO) throws Exception {
		List<CountVO> resultCount = manageDao.roomCount(countVO);
		return resultCount;
	}
	
	// 룸넘버 조회
	public String getRoomNo() throws Exception {
		String result = manageDao.getRoomNo();
		return result;
	}
	
	// 조건에따른 카운트 조회
	public int getCount(String roomKind) throws Exception {
		int result = manageDao.getCount(roomKind);
		return result;
	}
	
	// 사이트 카운트 조회
	public int getSiteCount() throws Exception {
		int result = manageDao.getSiteCount();
		return result;
	}
	
	// 기자재 넘버 조회
	public String getFixNo(String fixName) throws Exception {
		String result = manageDao.getFixNo(fixName);
		return result;
	}
	
	// 회의실/교육실 정보 조회
	public List<ConfVO> getConfInfo(ConfVO confInfo) throws Exception{

		List<ConfVO> resultList = manageDao.getConfInfo(confInfo);
		return resultList;
	}
	
	// 회의실/교육실 주소 조회
	public List<SiteVO> getConfAddr(SiteVO siteVO) throws Exception{

		List<SiteVO> result = manageDao.getConfAddr(siteVO);
		return result;
	}
	
	// 기자재 리스트 조회
	public List<GetFixVO> getFixList(GetFixVO getFixVO) throws Exception {
		
		List<GetFixVO> resultList = manageDao.getFixList(getFixVO);
		return resultList;
	}
	
	// 회의실/교육실 이름 조회
	public List<GetConfNameVO> getConfName(GetConfNameVO getConfNameVO) throws Exception {
		
		List<GetConfNameVO> resultList = manageDao.getConfName(getConfNameVO);
		return resultList;
	}
	
	// 회의실/교육실 업데이트 정보
	public int updateConfInfo(UdConfVO udConfVO) throws Exception {
		int updateConfInfo = manageDao.updateConfInfo(udConfVO);
		return updateConfInfo;
	}
	
	// 회의실/교육실 기자재 정보
	public int updateUseFix(GetFixVO getFixVO) throws Exception {
		int updateUseFix = manageDao.updateUseFix(getFixVO);
		return updateUseFix;
	}
	
	// 회의실/교육실 삭제
	public int deleteConf(String roomNo) throws Exception {
		int deleteResult = manageDao.deleteConf(roomNo);
		return deleteResult;
	}
	
	// 기자재 삭제
	public int deleteUseFix(String roomNo) throws Exception {
		int deleteResult = manageDao.deleteUseFix(roomNo);
		return deleteResult;
	}
//---------------------------------------건물 관련-------------------------------------------------------------------
	// 건물(근무지) 추가
	public int insertSite(SiteVO siteModel) throws Exception {
		int insertResult = manageDao.insertSite(siteModel);
		return insertResult;
	}
	
	// 건물(근무지) 번호 추가
	public String getSiteNo() throws Exception {
		String result = manageDao.getSiteNo();
		return result;
	}
	
	// 건물(근무지) 조회
	public List<SiteVO> selectList(SiteVO siteModel) throws Exception{

		List<SiteVO> resultList = manageDao.selectList(siteModel);
		return resultList;
	}
	
	// 건물(근무지) 조건 조회
	public List<SiteVO> selectOption(SiteVO siteModel) throws Exception{

		List<SiteVO> resultList = manageDao.selectOption(siteModel);
		return resultList;
	}
	
	// 건물정보 수정
	public int updateSite(SiteVO siteModel) throws Exception {
		int updateResult = manageDao.updateSite(siteModel);
		return updateResult;
	}
	// 건물 삭제
	public int deleteSite(String siteNo) throws Exception {
		int deleteResult = manageDao.deleteSite(siteNo);
		return deleteResult;
	}
//---------------------------------------건물 관련-------------------------------------------------------------------	
	// 회의실/교육실 리스트 페이징 관련
	public List<PagingVO> getConfList(PagingVO pagingModel) throws Exception{

		List<PagingVO> resultList = manageDao.getConfList(pagingModel);
		return resultList;
	}
	// 건물 리스트 페이징 관련 
	public List<PagingSiteVO> getSiteList(PagingSiteVO pagingModel) throws Exception{

		List<PagingSiteVO> resultList = manageDao.getSiteList(pagingModel);
		return resultList;
	}
}
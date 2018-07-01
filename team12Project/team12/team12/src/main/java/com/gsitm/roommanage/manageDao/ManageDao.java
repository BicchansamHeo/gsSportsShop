package com.gsitm.roommanage.manageDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gsitm.roommanage.mapper.ManageMapper;
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
 * 조현우	   06-09   회의실/교육실 등록 기본 폼 관련 DAO
 * 조현우         06-11 등록에 필요한 정보 조회 관련 DAO
 * 조현우         06-12 건물 등록 기본 폼 작성 및 등록 관련 DAO
 * 조현우         06-13 건물 정보와 연동시켜 등록 폼 자동 작성 코드 관련 DAO
 * 조현우	   06-15  이미지 업로드 코드 관련 DAO
 * 조현우         06-16 건물 및 회의실/교육실 업데이트 관련 DAO
 * 조현우         06-18 건물 및 회의실/교육실 삭제 컨트롤러 작성 및 회의실 리스트 조회 화면 관련 DAO
 * 조현우         06-20 회의실/교육실/건물 리스트 조회 페이징 및 상세보기 화면뿌려주기 관련 DAO
 * 조현우	   06-21  최종 점검 및 주석 점검 및 추가
 */
// ---------------------------------------회의실
// 관련-------------------------------------------------------------------

@Repository(value = "manageDao")
public class ManageDao {
	private static final Logger logger = LoggerFactory.getLogger(ManageDao.class);

	@Autowired
	protected SqlSession sqlSession;

	// 회의실 정보 조회
	public List<ConfVO> readList(ConfVO confVO) {
		List<ConfVO> list = null;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			list = manageMapper.readList(confVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return list;
	}

	// 회의실 정보 등록
	public int insertConference(ConfVO confVO) {
		int result = 0;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			manageMapper.insertConference(confVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 이미지 추가
	public int insertImg(ImgVO imgVO) {
		int result = 0;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			manageMapper.insertImg(imgVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 기자재 리스트 조회
	public List<FixVO> fixList(FixVO fixVO) {
		List<FixVO> list = null;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			list = manageMapper.fixList(fixVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return list;
	}

	// 기자재 추가
	public int insertFix(AddFixVO addFixVO) {
		int result = 0;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			manageMapper.insertFix(addFixVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 기자재 갯수 관련 카운트
	public List<CountVO> roomCount(CountVO countVO) {
		List<CountVO> list = null;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			list = manageMapper.roomCount(countVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return list;
	}

	// 방번호 가져오기
	public String getRoomNo() {
		String result = "";
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			result = "R_" + manageMapper.getRoomNo();
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 기자재 번호 가져오기
	public String getFixNo(String fixName) {
		String result = "";
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			result = manageMapper.getFixNo(fixName);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 회의실 정보 받는 DAO
	public List<ConfVO> getConfInfo(ConfVO confVO) {
		List<ConfVO> list = null;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			list = manageMapper.getConfInfo(confVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return list;
	}

	// 사이트 연동을 통한 회의실 주소 값 전달 DAO
	public List<SiteVO> getConfAddr(SiteVO siteVO) {
		List<SiteVO> result = null;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			result = manageMapper.getConfAddr(siteVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 기자재 정보 받는 DAO
	public List<GetFixVO> getFixList(GetFixVO getFixVO) {
		List<GetFixVO> result = null;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			result = manageMapper.getFixList(getFixVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 회의실 이름 받는 DAO
	public List<GetConfNameVO> getConfName(GetConfNameVO getConfNameVO) {
		List<GetConfNameVO> result = null;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			result = manageMapper.getConfName(getConfNameVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 회의실 업데이트
	public int updateConfInfo(UdConfVO udConfVO) {
		int result = 0;
		logger.info(udConfVO.toString());
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			manageMapper.updateConfInfo(udConfVO);
			logger.info(udConfVO.toString());
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 업데이트 기존 사용 기자재
	public int updateUseFix(GetFixVO getFixVO) {
		int result = 0;
		logger.info(getFixVO.toString());
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			manageMapper.updateUseFix(getFixVO);
			logger.info(getFixVO.toString());
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 회의실 삭제
	public int deleteConf(String roomNo) {
		int result = 0;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			manageMapper.deleteConf(roomNo);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 기존 기자재 삭제
	public int deleteUseFix(String roomNo) {
		int result = 0;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			manageMapper.deleteUseFix(roomNo);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// ---------------------------------------건물(근무지)
	// 관련-------------------------------------------------------------------
	// 건물(근무지) 추가 관련
	public int insertSite(SiteVO siteVO) {
		int result = 0;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			manageMapper.insertSite(siteVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 건물(근무지) 번호 값 전달
	public String getSiteNo() {
		String result = "";
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			result = "W_" + manageMapper.getSiteNo();
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 건물(근무지) 정보 조회
	public List<SiteVO> selectList(SiteVO siteVO) {
		List<SiteVO> list = null;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			list = manageMapper.selectList(siteVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return list;
	}

	// 건물(근무지) select 옵션 관련 조회
	public List<SiteVO> selectOption(SiteVO siteVO) {
		List<SiteVO> list = null;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			list = manageMapper.selectOption(siteVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return list;
	}

	// 건물(근무지) UPDATE
	public int updateSite(SiteVO siteVO) {
		int result = 0;
		logger.info(siteVO.toString());
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			manageMapper.updateSite(siteVO);
			logger.info(siteVO.toString());
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 건물(근무지) 삭제
	public int deleteSite(String siteNo) {
		int result = 0;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			manageMapper.deleteSite(siteNo);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

//----------------------------------상세정보관련--------------------------------------------------------------------------------------
	// 상세정보 화면 값 전달
	public ConfVO detailList(ConfVO confVO) {
		ConfVO list = null;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			list = manageMapper.detailList(confVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return list;
	}

	// 상세정보 화면 이미지 전달
	public List<ImgVO> detailImgs(ImgVO imgVO) {
		List<ImgVO> list = null;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			list = manageMapper.detailImgs(imgVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return list;
	}

	// 회의실/교육실 정보조회 부가
	public List<ConfVO> readList2(ConfVO confVO) {
		List<ConfVO> list = null;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			list = manageMapper.readList2(confVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return list;
	}

	// 회의실/교육실 카운트 조회
	public int getCount(String roomKind) {
		int result = 0;
		logger.info("roomKind : " + roomKind);
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			result = manageMapper.getCount(roomKind);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// ---------------------------------페이징--------------------------------------------------------------------

	// 회의실 리스트 페이징 관련
	public List<PagingVO> getConfList(PagingVO pagingVO) {
		List<PagingVO> result = null;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			result = manageMapper.getConfList(pagingVO);
			System.out.println("ConfName Result : " + result);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 건물 리스트 페이징 관련
	public List<PagingSiteVO> getSiteList(PagingSiteVO pagingSiteVO) {
		List<PagingSiteVO> result = null;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			result = manageMapper.getSiteList(pagingSiteVO);
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

	// 건물(근무지) 카운트
	public int getSiteCount() {
		int result = 0;
		try {
			ManageMapper manageMapper = sqlSession.getMapper(ManageMapper.class);
			result = manageMapper.getSiteCount();
		} catch (Exception e) {
			logger.debug(" [ERROR] " + e);
		}
		return result;
	}

}

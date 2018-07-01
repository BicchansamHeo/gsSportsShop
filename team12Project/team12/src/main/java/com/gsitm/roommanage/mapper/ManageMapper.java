package com.gsitm.roommanage.mapper;

import java.util.List;

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
public interface ManageMapper {

	int insertConference(ConfVO vo);
	int insertSite(SiteVO vo);
	int insertImg(ImgVO vo);
	int updateSite(SiteVO vo);
	int deleteSite(String siteNo);
	int insertFix(AddFixVO vo);
	int getRoomNo();
	int updateConfInfo(UdConfVO vo);
	int updateUseFix(GetFixVO vo);
	int getSiteNo();
	int deleteConf(String roomNo);
	int deleteUseFix(String roomNo);
	int getCount(String roomKind);
	int getSiteCount();
	String getFixNo(String fixName);
	List<ConfVO> readList(ConfVO vo);
	List<ConfVO> getConfInfo(ConfVO vo);
	List<SiteVO> selectList(SiteVO vo);
	List<SiteVO> selectOption(SiteVO vo);
	List<FixVO> fixList(FixVO vo);
	List<CountVO> roomCount(CountVO vo);
	List<SiteVO> getConfAddr(SiteVO siteVO);
	List<GetFixVO> getFixList(GetFixVO getFixVO);
	List<GetConfNameVO> getConfName(GetConfNameVO getConfNameVO);
	List<PagingVO> getConfList(PagingVO vo);
	List<PagingSiteVO> getSiteList(PagingSiteVO vo);
	List<ConfVO> readList2(ConfVO vo);
	ConfVO detailList(ConfVO vo);
	List<ImgVO> detailImgs(ImgVO vo);

}

package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBUtils;
import vo.ArtVO;
import vo.MentoVO;

public class Service {

	public List<ArtVO> artList() {
		List<ArtVO> list = new ArrayList<ArtVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtils.getConn();
			String sql = "SELECT artist_id,artist_name, artist_birth, "
					+ " decode(artist_gender, 'M','남성','F','여성') artist_gender , "
					+ " decode(talent, '1','보컬','2','댄스','3','랩') talent,agency  FROM tbl_artist_201905 ORDER BY artist_id";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ArtVO vo = new ArtVO();
				
				String year = rs.getString("artist_birth").substring(0,4);
				String month = rs.getString("artist_birth").substring(4,6);
				String day = rs.getString("artist_birth").substring(6,8);
				
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_birth(year + "년" + month + "월" + day + "일");
				vo.setArtist_gender(rs.getString("artist_gender"));
				vo.setTalent(rs.getString("talent"));
				vo.setAgency(rs.getString("agency"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int artInsert(ArtVO vo) throws SQLException{
		int n = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con =DBUtils.getConn();
			String sql = "INSERT INTO tbl_artist_201905 VALUES (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getArtist_id());
			pstmt.setString(2, vo.getArtist_name());
			pstmt.setString(3, vo.getArtist_birth());
			pstmt.setString(4, vo.getArtist_gender());
			pstmt.setString(5, vo.getTalent());
			pstmt.setString(6, vo.getAgency());
			
			n = pstmt.executeUpdate();
			
			if(n > 0) {
				con.commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
			con.rollback();
			e.printStackTrace();
		}
		return n;
	}


	public List<MentoVO> mentoList() {
		List<MentoVO> p_list = new ArrayList<MentoVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtils.getConn();
			String sql = "SELECT DISTINCT a.artist_id, artist_name, artist_gender, point, RANK() OVER (ORDER BY point DESC) rank, mento_name FROM tbl_artist_201905 a, tbl_mento_201905 b, tbl_point_201905 c WHERE a.artist_id = c.artist_id AND b.mento_id = c.mento_id ORDER BY artist_id";  	
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				MentoVO vo = new MentoVO();
				
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_gender(rs.getString("artist_gender"));
				vo.setPoint(rs.getString("point"));
				vo.setRank(rs.getString("rank"));
				vo.setMento_name(rs.getString("mento_name"));
				
				p_list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p_list;
	}

	

}

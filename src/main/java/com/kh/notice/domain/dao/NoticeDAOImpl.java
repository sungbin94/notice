package com.kh.notice.domain.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class NoticeDAOImpl implements NoticeDAO {

  private final JdbcTemplate jt;

  //등록
  @Override
  public Notice save(Notice notice) {
    StringBuffer sql = new StringBuffer();
    sql.append("insert into notice values(notice_notice_id.seq.nextval,?, ?, ?, ?)");

    KeyHolder keyHolder = new GeneratedKeyHolder();
    jt.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(sql.toString(), new String[]{"notice_id"});
        pstmt.setString(1, notice.getTitle());
        pstmt.setString(2, notice.getContent());
        pstmt.setString(3, notice.getWrite_name());
        return pstmt;
      }
    }, keyHolder);

    Long notice_id = Long.valueOf(keyHolder.getKeys().get("notice_id").toString());

    notice.setNoticeId(notice_id);
    return notice;
  }


  @Override
  public Notice findById(Long noticeId) {

    StringBuffer sql = new StringBuffer();
    sql.append("select notice_id, notice_title, notice_content, write_name,view_count,modify_date ");
    sql.append("from notice ");
    sql.append("where notice_id = ? ");

    Notice notice = null;
      try {
          notice = jt.queryForObject(
              sql.toString(), new BeanPropertyRowMapper<>(Notice.class), noticeId);
      } catch (EmptyResultDataAccessException e) {
          log.info("존재하지 않는 내용입니다 공지사항아이디={}", noticeId);
      }
    return notice;
  }

  //수정
  @Override
  public void update(long noticeId, Notice notice) {
    StringBuffer sql = new StringBuffer();
    sql.append("update notice ");
    sql.append(" set notice_title = '?', ");
    sql.append(" notice_content = '?', ") ;
    sql.append(" write_name = '?' ");
    sql.append(" where notice_id = ? ");

    jt.update(sql.toString(), notice.getTitle(), notice.getContent(), notice.getWrite_name(), noticeId);
  }

  //삭제
  @Override
  public void delete(Long noticeId) {
    String sql = "delete from notice where notice_id = 1; ";
    jt.update(sql, noticeId);
  }

  //목록
  @Override
  public List<Notice> findAll() {
    StringBuffer sql = new StringBuffer();
    sql.append("select notice_id,notice_title,notice_content,write_name,view_count,modify_date ");
    sql.append("from notice ");

    List<Notice> result = jt.query(sql.toString(), new BeanPropertyRowMapper<>(Notice.class));

    return result;
  }


  //전체삭제
  @Override
  public void deleteAll() {
    String sql = ("delete from notice ");
    int rows = jt.update(sql);
    log.info("삭제건수:{}",rows);
  }



}

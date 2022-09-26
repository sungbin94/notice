package com.kh.notice.domain.dao.notice;

import com.kh.notice.domain.entity.Notice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

  private final JdbcTemplate jdbcTemplate;

  /**
   * 등록
   * @param notice
   * @return
   */
  @Override
  public Notice create(Notice notice) {

    StringBuffer sql = new StringBuffer();
    sql.append("insert into notice(notice_id, title, content, write_name, count) ");
    sql.append("values(notice_notice_id_seq.nextval,?,?,?,?) ");

    //SQL실행
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(
            sql.toString(),
            new String[]{"notice_id"}  // insert 후 insert 레코드중 반환할 컬럼명, KeyHolder에 저장됨.
        );

        pstmt.setString(1, notice.getTitle());
        pstmt.setString(2, notice.getContent());
        pstmt.setString(3, notice.getWrite_name());

        return pstmt;
      }
    },keyHolder);

    long notice_id = Long.valueOf(keyHolder.getKeys().get("notice_id").toString());
    return selectOne(notice_id);
  }

  /**
   *전체조회
   * @return
   */
  @Override
  public List<Notice> selectAll() {
    StringBuffer sql = new StringBuffer();
    sql.append("select notice_id, title, content, write_name, count, udate ");
    sql.append("  from notice ");
    sql.append("order by notice_id desc ");

    List<Notice> list = jdbcTemplate.query(
        sql.toString(), new BeanPropertyRowMapper<>(Notice.class));

    return list;
  }

  /**
   * 상세조회
   * @param noticeId
   * @return
   */
  @Override
  public Notice selectOne(Long noticeId) {
    StringBuffer sql = new StringBuffer();
    sql.append("select notice_id, title,content,write_name, count,  udate ");
    sql.append("from notice ");
    sql.append("where notice_id = ? ");

    List<Notice> query = jdbcTemplate.query(
        sql.toString(), new BeanPropertyRowMapper<>(Notice.class), noticeId);

    return (query.size() == 1) ? query.get(0) : null;
  }

  /**
   * 수정
   * @param notice
   * @return
   */
  @Override
  public Notice update(Notice notice) {
    StringBuffer sql = new StringBuffer();
    sql.append("update notice ");
    sql.append("set title = ? , ");
    sql.append("    content = ? , ");
    sql.append("    udate   = systimestamp ");
    sql.append("where notice_id = ? ");

    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(
            sql.toString(),
            new String[]{"notice_id"}  // update 후 update 레코드중 반환할 컬럼명, KeyHolder에 저장됨.
        );

        pstmt.setString(1, notice.getTitle());
        pstmt.setString(2, notice.getContent());
        pstmt.setLong(3, notice.getNoticeId());

        return pstmt;
      }
    },keyHolder);

    long notice_id = Long.valueOf(keyHolder.getKeys().get("notice_id").toString());
    return selectOne(notice_id);
  }

  /**
   * 삭제
   * @param noticeId
   * @return
   */
  @Override
  public int delete(Long noticeId) {
    StringBuffer sql = new StringBuffer();
    sql.append("delete from notice ");
    sql.append(" where notice_id = ? ");

    int cnt = jdbcTemplate.update(sql.toString(), noticeId);

    return cnt;
  }

  /**
   * 조회수 증가
   * @param noticeId
   * @return
   */
  @Override
  public int updateCount(Long noticeId) {
    StringBuffer sql = new StringBuffer();
    sql.append("update notice ");
    sql.append("   set count = count + 1 ");
    sql.append(" where notice_id = ? ");

    int cnt = jdbcTemplate.update(sql.toString(), noticeId);

    return cnt;
  }
}

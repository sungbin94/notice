package com.kh.notice.domain.dao.notice;

import com.kh.notice.domain.entity.notice.Notice;
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

  /**
   * 등록
   * @param notice
   * @return
   */
  @Override
  public Notice save(Notice notice) {

    StringBuffer sql = new StringBuffer();
    sql.append("insert into notice(notice_id, title, content,attachments, write, count) ");
    sql.append("values(notice_notice_id_seq.nextval,?,?,?,'관리자',1) ");

    //SQL실행
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jt.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(
            sql.toString(),
            new String[]{"notice_id"}  // insert 후 insert 레코드중 반환할 컬럼명, KeyHolder에 저장됨.
        );

        pstmt.setString(1, notice.getTitle());
        pstmt.setString(2, notice.getContent());
        pstmt.setString(3, notice.getWrite());
        pstmt.setString(4,notice.getAttachments());
//        pstmt.setLong(4,notice.getCount());

        return pstmt;
      }
    },keyHolder);

    long notice_id = Long.valueOf(keyHolder.getKeys().get("notice_id").toString());
    return read(notice_id);
  }

  /**
   *전체조회
   * @return
   */
  @Override
  public List<Notice> selectAll() {
    StringBuffer sql = new StringBuffer();
    sql.append("select notice_id, title, content, write, attachments, count, udate ");
    sql.append("  from notice ");
    sql.append("order by notice_id desc ");

    List<Notice> list = jt.query(
        sql.toString(), new BeanPropertyRowMapper<>(Notice.class));

    return list;
  }

  /**
   * 상세조회
   * @param noticeId
   * @return
   */
  @Override
  public Notice read(Long noticeId) {
    StringBuffer sql = new StringBuffer();
    sql.append("select notice_id, title,content,attachments,write, count,  udate ");
    sql.append("from notice ");
    sql.append("where notice_id = ? ");

    Notice notice = null;
    try {
      notice = jt.queryForObject(
          sql.toString(), new BeanPropertyRowMapper<>(Notice.class), noticeId);
    } catch (EmptyResultDataAccessException e) {
      log.info("삭제대상이 없습니다 공지사항넘버={}", noticeId);
    }
    return notice;
  }

  /**
   * 수정
   * @param notice
   * @return
   */
  @Override
  public int update(Long noticeId, Notice notice) {
    StringBuffer sql = new StringBuffer();
    sql.append("update notice ");
    sql.append("set title = ? , ");
    sql.append("    content = ? , ");
    sql.append("    attachments = ?, ");
    sql.append("    udate   = sysdate ");
    sql.append("where notice_id = ? ");

    int affectedRow = jt.update(sql.toString(), notice.getTitle(), notice.getContent(), notice.getAttachments(), noticeId);

    return affectedRow;
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

    int cnt = jt.update(sql.toString(), noticeId);

    return cnt;
  }

  /**
   * 조회수 증가
   *
   * @param noticeId 게시글 번호
   * @return 수정건수
   */
  @Override
  public int increaseViewCount(Long noticeId) {
    String sql = "update notice set count = count +1 where notice_id = ? ";
    int affectedRow = jt.update(sql, noticeId);
    return affectedRow;
  }
}
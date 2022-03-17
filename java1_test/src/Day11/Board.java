package Day11;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Board {
	
	// 1. 필드
	private String title;
	private String content;
	private String password;
	private String writer;
	private int viewcount;
	private String date;
	private ArrayList<Reply> replylist = new ArrayList<>(); //////////////왜? 댓글리스트???????????????
	
	// 2. 생성자
	public Board() {}

	public Board(String title, String content, String password, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.password = password;
		this.writer = writer;
		
		java.util.Date date = new java.util.Date();   ////////////////////////////////?????????
		
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		
		this.date = format.format(date);

	}

	public Board(String title, String content, String password, String writer, int viewcount, String date,
			ArrayList<Reply> replylist) {
		super();
		this.title = title;
		this.content = content;
		this.password = password;
		this.writer = writer;
		this.viewcount = viewcount;
		this.date = date;
		this.replylist = replylist;
	}

	// 3. 메소드
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayList<Reply> getReplylist() {
		return replylist;
	}

	public void setReplylist(ArrayList<Reply> replylist) {
		this.replylist = replylist;
	}

	
	
	
	
}

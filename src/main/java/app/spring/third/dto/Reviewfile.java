package app.spring.third.dto;

public class Reviewfile {
	private int rf_idx;
	private int board_idx;
	private String rf_filename;
	public Reviewfile(int rf_idx, int board_idx, String rf_filename) {
		super();
		this.rf_idx = rf_idx;
		this.board_idx = board_idx;
		this.rf_filename = rf_filename;
	}
	public Reviewfile() {
		super();
	}
	public int getRf_idx() {
		return rf_idx;
	}
	public void setRf_idx(int rf_idx) {
		this.rf_idx = rf_idx;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getRf_filename() {
		return rf_filename;
	}
	public void setRf_filename(String rf_filename) {
		this.rf_filename = rf_filename;
	}
	@Override
	public String toString() {
		return "Reviewfile [rf_idx=" + rf_idx + ", board_idx=" + board_idx + ", rf_filename=" + rf_filename + "]";
	}
	
	
}

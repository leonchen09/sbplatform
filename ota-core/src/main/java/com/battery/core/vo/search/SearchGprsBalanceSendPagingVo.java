package com.battery.core.vo.search;

import java.util.Date;

import com.battery.common.vo.search.PageEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class was generated by Bill Generator.
 * This class corresponds to the database table gprs_balance_send  均衡控制指令发送表	
 *
 * @zdmgenerated 2017-13-19 07:13
 */
@ApiModel(value="均衡控制指令发送表	查询",description="均衡控制指令发送表	查询描述")
public class SearchGprsBalanceSendPagingVo extends PageEntity {
    /**
     * This field corresponds to the database column gprs_balance_send.id  
     */
    @ApiModelProperty(value="pk",required=false)
    private Integer id;

    /**
     * This field corresponds to the database column gprs_balance_send.gprs_id  
     */
    @ApiModelProperty(value="gprsId",example="gprsId",required=false)
    private String gprsId;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_1  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell1;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_2  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell2;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_3  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell3;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_4  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell4;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_5  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell5;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_6  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell6;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_7  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell7;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_8  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell8;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_9  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell9;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_10  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell10;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_11  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell11;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_12  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell12;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_13  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell13;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_14  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell14;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_15  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell15;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_16  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell16;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_17  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell17;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_18  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell18;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_19  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell19;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_20  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell20;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_21  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell21;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_22  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell22;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_23  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell23;

    /**
     * This field corresponds to the database column gprs_balance_send.cell_24  0: 关闭2:主动放3:主动充
     */
    @ApiModelProperty(value="0: 关闭2:主动放3:主动充",required=false)
    private Byte cell24;

    /**
     * This field corresponds to the database column gprs_balance_send.send_done  
     */
    @ApiModelProperty(value="sendDone",required=false)
    private Byte sendDone;

    /**
     * This field corresponds to the database column gprs_balance_send.send_time  
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value="sendTime")
    private Date sendTime;
    
    //均衡强制执行标志 1 强制执行 0 非强制执行
    @ApiModelProperty(value="mode")
    private Integer mode;

    public Integer getMode() {
		return mode;
	}

	public void setMode(Integer mode) {
		this.mode = mode;
	}

	/**
     * This method returns the value of the database column gprs_balance_send.id  
     * @return the value of gprs_balance_send.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.id  
     * @param id the value for gprs_balance_send.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.gprs_id  
     * @return the value of gprs_balance_send.gprs_id
     */
    public String getGprsId() {
        return gprsId;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.gprs_id  
     * @param gprsId the value for gprs_balance_send.gprs_id
     */
    public void setGprsId(String gprsId) {
        this.gprsId = gprsId == null ? null : gprsId.trim();
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_1  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_1
     */
    public Byte getCell1() {
        return cell1;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_1  0: 关闭
2:主动放
3:主动充
     * @param cell1 the value for gprs_balance_send.cell_1
     */
    public void setCell1(Byte cell1) {
        this.cell1 = cell1;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_2  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_2
     */
    public Byte getCell2() {
        return cell2;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_2  0: 关闭
2:主动放
3:主动充
     * @param cell2 the value for gprs_balance_send.cell_2
     */
    public void setCell2(Byte cell2) {
        this.cell2 = cell2;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_3  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_3
     */
    public Byte getCell3() {
        return cell3;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_3  0: 关闭
2:主动放
3:主动充
     * @param cell3 the value for gprs_balance_send.cell_3
     */
    public void setCell3(Byte cell3) {
        this.cell3 = cell3;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_4  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_4
     */
    public Byte getCell4() {
        return cell4;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_4  0: 关闭
2:主动放
3:主动充
     * @param cell4 the value for gprs_balance_send.cell_4
     */
    public void setCell4(Byte cell4) {
        this.cell4 = cell4;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_5  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_5
     */
    public Byte getCell5() {
        return cell5;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_5  0: 关闭
2:主动放
3:主动充
     * @param cell5 the value for gprs_balance_send.cell_5
     */
    public void setCell5(Byte cell5) {
        this.cell5 = cell5;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_6  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_6
     */
    public Byte getCell6() {
        return cell6;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_6  0: 关闭
2:主动放
3:主动充
     * @param cell6 the value for gprs_balance_send.cell_6
     */
    public void setCell6(Byte cell6) {
        this.cell6 = cell6;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_7  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_7
     */
    public Byte getCell7() {
        return cell7;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_7  0: 关闭
2:主动放
3:主动充
     * @param cell7 the value for gprs_balance_send.cell_7
     */
    public void setCell7(Byte cell7) {
        this.cell7 = cell7;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_8  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_8
     */
    public Byte getCell8() {
        return cell8;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_8  0: 关闭
2:主动放
3:主动充
     * @param cell8 the value for gprs_balance_send.cell_8
     */
    public void setCell8(Byte cell8) {
        this.cell8 = cell8;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_9  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_9
     */
    public Byte getCell9() {
        return cell9;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_9  0: 关闭
2:主动放
3:主动充
     * @param cell9 the value for gprs_balance_send.cell_9
     */
    public void setCell9(Byte cell9) {
        this.cell9 = cell9;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_10  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_10
     */
    public Byte getCell10() {
        return cell10;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_10  0: 关闭
2:主动放
3:主动充
     * @param cell10 the value for gprs_balance_send.cell_10
     */
    public void setCell10(Byte cell10) {
        this.cell10 = cell10;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_11  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_11
     */
    public Byte getCell11() {
        return cell11;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_11  0: 关闭
2:主动放
3:主动充
     * @param cell11 the value for gprs_balance_send.cell_11
     */
    public void setCell11(Byte cell11) {
        this.cell11 = cell11;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_12  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_12
     */
    public Byte getCell12() {
        return cell12;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_12  0: 关闭
2:主动放
3:主动充
     * @param cell12 the value for gprs_balance_send.cell_12
     */
    public void setCell12(Byte cell12) {
        this.cell12 = cell12;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_13  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_13
     */
    public Byte getCell13() {
        return cell13;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_13  0: 关闭
2:主动放
3:主动充
     * @param cell13 the value for gprs_balance_send.cell_13
     */
    public void setCell13(Byte cell13) {
        this.cell13 = cell13;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_14  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_14
     */
    public Byte getCell14() {
        return cell14;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_14  0: 关闭
2:主动放
3:主动充
     * @param cell14 the value for gprs_balance_send.cell_14
     */
    public void setCell14(Byte cell14) {
        this.cell14 = cell14;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_15  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_15
     */
    public Byte getCell15() {
        return cell15;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_15  0: 关闭
2:主动放
3:主动充
     * @param cell15 the value for gprs_balance_send.cell_15
     */
    public void setCell15(Byte cell15) {
        this.cell15 = cell15;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_16  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_16
     */
    public Byte getCell16() {
        return cell16;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_16  0: 关闭
2:主动放
3:主动充
     * @param cell16 the value for gprs_balance_send.cell_16
     */
    public void setCell16(Byte cell16) {
        this.cell16 = cell16;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_17  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_17
     */
    public Byte getCell17() {
        return cell17;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_17  0: 关闭
2:主动放
3:主动充
     * @param cell17 the value for gprs_balance_send.cell_17
     */
    public void setCell17(Byte cell17) {
        this.cell17 = cell17;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_18  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_18
     */
    public Byte getCell18() {
        return cell18;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_18  0: 关闭
2:主动放
3:主动充
     * @param cell18 the value for gprs_balance_send.cell_18
     */
    public void setCell18(Byte cell18) {
        this.cell18 = cell18;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_19  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_19
     */
    public Byte getCell19() {
        return cell19;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_19  0: 关闭
2:主动放
3:主动充
     * @param cell19 the value for gprs_balance_send.cell_19
     */
    public void setCell19(Byte cell19) {
        this.cell19 = cell19;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_20  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_20
     */
    public Byte getCell20() {
        return cell20;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_20  0: 关闭
2:主动放
3:主动充
     * @param cell20 the value for gprs_balance_send.cell_20
     */
    public void setCell20(Byte cell20) {
        this.cell20 = cell20;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_21  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_21
     */
    public Byte getCell21() {
        return cell21;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_21  0: 关闭
2:主动放
3:主动充
     * @param cell21 the value for gprs_balance_send.cell_21
     */
    public void setCell21(Byte cell21) {
        this.cell21 = cell21;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_22  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_22
     */
    public Byte getCell22() {
        return cell22;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_22  0: 关闭
2:主动放
3:主动充
     * @param cell22 the value for gprs_balance_send.cell_22
     */
    public void setCell22(Byte cell22) {
        this.cell22 = cell22;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_23  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_23
     */
    public Byte getCell23() {
        return cell23;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_23  0: 关闭
2:主动放
3:主动充
     * @param cell23 the value for gprs_balance_send.cell_23
     */
    public void setCell23(Byte cell23) {
        this.cell23 = cell23;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.cell_24  0: 关闭
2:主动放
3:主动充
     * @return the value of gprs_balance_send.cell_24
     */
    public Byte getCell24() {
        return cell24;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.cell_24  0: 关闭
2:主动放
3:主动充
     * @param cell24 the value for gprs_balance_send.cell_24
     */
    public void setCell24(Byte cell24) {
        this.cell24 = cell24;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.send_done  
     * @return the value of gprs_balance_send.send_done
     */
    public Byte getSendDone() {
        return sendDone;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.send_done  
     * @param sendDone the value for gprs_balance_send.send_done
     */
    public void setSendDone(Byte sendDone) {
        this.sendDone = sendDone;
    }

    /**
     * This method returns the value of the database column gprs_balance_send.send_time  
     * @return the value of gprs_balance_send.send_time
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * This method sets the value of the database column gprs_balance_send.send_time  
     * @param sendTime the value for gprs_balance_send.send_time
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
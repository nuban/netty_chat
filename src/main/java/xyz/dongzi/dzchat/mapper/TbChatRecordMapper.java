package xyz.dongzi.dzchat.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.dongzi.dzchat.pojo.TbChatRecord;
import xyz.dongzi.dzchat.pojo.TbChatRecordExample;

import java.util.List;

public interface TbChatRecordMapper {
    int countByExample(TbChatRecordExample example);

    int deleteByExample(TbChatRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbChatRecord record);

    int insertSelective(TbChatRecord record);

    List<TbChatRecord> selectByExample(TbChatRecordExample example);

    TbChatRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbChatRecord record, @Param("example") TbChatRecordExample example);

    int updateByExample(@Param("record") TbChatRecord record, @Param("example") TbChatRecordExample example);

    int updateByPrimaryKeySelective(TbChatRecord record);

    int updateByPrimaryKey(TbChatRecord record);
}
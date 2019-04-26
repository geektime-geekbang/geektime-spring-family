package geektime.spring.data.mybatis.mapper;

import geektime.spring.data.mybatis.model.Coffee;
import geektime.spring.data.mybatis.model.CoffeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface CoffeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Apr 26 01:35:42 PST 2019
     */
    long countByExample(CoffeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Apr 26 01:35:42 PST 2019
     */
    int deleteByExample(CoffeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Apr 26 01:35:42 PST 2019
     */
    @Delete({
        "delete from T_COFFEE",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Apr 26 01:35:42 PST 2019
     */
    @Insert({
        "insert into T_COFFEE (NAME, PRICE, ",
        "CREATE_TIME, UPDATE_TIME)",
        "values (#{name,jdbcType=VARCHAR}, #{price,jdbcType=BIGINT,typeHandler=geektime.spring.data.mybatis.handler.MoneyTypeHandler}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="CALL IDENTITY()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Coffee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Apr 26 01:35:42 PST 2019
     */
    int insertSelective(Coffee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Apr 26 01:35:42 PST 2019
     */
    List<Coffee> selectByExampleWithRowbounds(CoffeeExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Apr 26 01:35:42 PST 2019
     */
    List<Coffee> selectByExample(CoffeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Apr 26 01:35:42 PST 2019
     */
    @Select({
        "select",
        "ID, NAME, PRICE, CREATE_TIME, UPDATE_TIME",
        "from T_COFFEE",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("geektime.spring.data.mybatis.mapper.CoffeeMapper.BaseResultMap")
    Coffee selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Apr 26 01:35:42 PST 2019
     */
    int updateByExampleSelective(@Param("record") Coffee record, @Param("example") CoffeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Apr 26 01:35:42 PST 2019
     */
    int updateByExample(@Param("record") Coffee record, @Param("example") CoffeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Apr 26 01:35:42 PST 2019
     */
    int updateByPrimaryKeySelective(Coffee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Apr 26 01:35:42 PST 2019
     */
    @Update({
        "update T_COFFEE",
        "set NAME = #{name,jdbcType=VARCHAR},",
          "PRICE = #{price,jdbcType=BIGINT,typeHandler=geektime.spring.data.mybatis.handler.MoneyTypeHandler},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Coffee record);
}
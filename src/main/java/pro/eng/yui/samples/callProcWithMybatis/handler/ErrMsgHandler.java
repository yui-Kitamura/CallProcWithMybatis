package pro.eng.yui.samples.callProcWithMybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import pro.eng.yui.samples.callProcWithMybatis.dto.colType.ErrMsg;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(ErrMsg.class)
public class ErrMsgHandler extends BaseTypeHandler<ErrMsg> {

    public ErrMsgHandler(){
        super();
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ErrMsg parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,parameter.get());
    }

    @Override
    public ErrMsg getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String val = rs.getString(columnName);
        return val == null ? null : new ErrMsg(val);
    }

    @Override
    public ErrMsg getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String val = rs.getString(columnIndex);
        return val == null ? null : new ErrMsg(val);
    }

    @Override
    public ErrMsg getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String val = cs.getString(columnIndex);
        return val == null ? null : new ErrMsg(val);
    }
}

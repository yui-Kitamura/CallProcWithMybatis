package pro.eng.yui.samples.callProcWithMybatis.dto.colType;

public class ErrMsg {

    private final String msg;
    public String get(){
        return msg;
    }

    public ErrMsg(String msg){
        this.msg = msg;
    }

    @Override
    public String toString(){
        return get();
    }

    @Override
    public int hashCode() {
        int hash = 27, key = 13;
        hash = hash * key + msg.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ErrMsg objMsg){
            boolean isSame = false;
            //noinspection RedundantIfStatement
            if(this.msg.equals(objMsg.msg)){
                isSame = true;
            }
            return isSame;
        }else{
            return false;
        }
    }
}

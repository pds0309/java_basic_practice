package e01;

// why ibatis?
// -> 근본이 ibatis

import e01.dto.DeptDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DeptMybatisAllInOneApplication {

    public static void main(String[] args) {
        // 니가 만든 Config.xml 등록
        String resource = "e01/Configuration.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        // 사용예시
        // session.insert(String id) return int;
        // session.insert(String id , Object obj) return int;

        // 조회
        //  단일 - .selectOne(); return T
        //  다중 - .selectList(); return List<E>

        try {
            List<DeptDTO> list = session.selectList("e01.DeptMapper.selectAllDesc");
            for (DeptDTO dto : list) {
                System.out.println(dto);
            }
        } finally {
            session.close();
        }
        // query like
        SqlSession session1 = sqlSessionFactory.openSession();
        try{
            List<DeptDTO> list = session1.selectList("e01.DeptMapper.selectByContainsDName","괴");
            for(DeptDTO dto : list){
                System.out.println(dto);
            }
        }
        finally {
            session1.close();
        }


        SqlSession session2 = sqlSessionFactory.openSession();
        try {
            DeptDTO dto = session2.selectOne("e01.DeptMapper.selectOneByDeptNo", 0);
            System.out.println(dto);
        } finally {
            session2.close();
        }

        SqlSession session3 = sqlSessionFactory.openSession();
        try {
            List<DeptDTO> dtos = session3.selectList("e01.DeptMapper.selectByDName", "괴발");
            for (DeptDTO dto : dtos) {
                System.out.println(dto);
            }
        } finally {
            session3.close();
        }
        System.out.println(" ");

        SqlSession session4 = sqlSessionFactory.openSession();
        try {
            List<DeptDTO> dtos = session4.selectList("e01.DeptMapper.selectByDNameLoc"
                    , new DeptDTO(1, "과테말라", "괴발"));
            for (DeptDTO dto : dtos) {
                System.out.println(dto);
            }
        } finally {
            session4.close();
        }

//        SqlSession session5 = sqlSessionFactory.openSession();
//        try{
//            int num = session5.insert("e01.DeptMapper.insert",new DeptDTO(99,"광명","갑환"));
//            if(num == 1){
//                System.out.println("Saved!");
//                // 커밋 명시 필요
//                session5.commit();
//            }
//        }
//        finally {
//            session5.close();
//        }

        SqlSession session6 = sqlSessionFactory.openSession();
        try {
            int num = session6.update("e01.DeptMapper.update", new DeptDTO(10, "과테말라", "굉발"));
            if (num == 1) {
                System.out.println("Changed!!");
                session6.commit();
            }
        } finally {
            session6.close();
        }

        SqlSession session7 = sqlSessionFactory.openSession();

        try {
            int num = session7.delete("e01.DeptMapper.delete", 10);
            if (num != 0) {
                System.out.println(num + " deleted");
                session7.commit();
            }
        } finally {
            session7.close();
        }
    }
}

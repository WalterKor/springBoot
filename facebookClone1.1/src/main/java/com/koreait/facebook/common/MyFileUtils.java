package com.koreait.facebook.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.UUID;

@Component
public class MyFileUtils {

    @Value("${spring.servlet.multipart.location}")
    private String uploadImagePath; //"D:/springImg"

    //폴더 만들기
    public void makeFolders(String path) {
        File folder = new File(path);
        //mkdirs 그냥 이거 쓰세요 에러 날 일이 없습니다.
        folder.mkdirs();
    }

    //저장 경로 만들기
    public String getSavePath(String path) {

        return uploadImagePath + "/" + path;
        //return "D:/springImg" + "/" + "profile/10"
        //return "D:/springImg/profile/10";
    }

    //랜덤 파일명 만들기  UUID로 랜덤한 파일명을 만든다
    public String getRandomFileNm() {
        return UUID.randomUUID().toString();
    }

    //확장자 얻기               "aaa.jpg"
    public String getExt(String fileNm) {
        return fileNm.substring(fileNm.lastIndexOf(".") + 1);
    }


    //랜덤 파일명 만들기 (with 확장자)    "aaa.jpg" 오리지널을 통해서 확장자를 얻는다
    public String getRandomFileNm(String originFileNm) {
        return getRandomFileNm() + "." + getExt(originFileNm);
        //return "aslkdfjaslkf2130asdwds" + "." + "jpg"
        //return "aslkdfjaslkf2130asdwds.jpg"

    }



    //랜덤 파일명 만들기
    public String getRandomFileNm(MultipartFile file) {
        return getRandomFileNm(file.getOriginalFilename());
    }



    //파일 저장 & 랜덤파일명 리턴                  target = "profile/10"
    public String transferTo(MultipartFile mf, String target) {
        String fileNm = getRandomFileNm(mf); //"aslkdfjaslkf2130asdwds.jpg"
        String basePath = getSavePath(target); //이미지를 저장할 절대경로값을 만든다. "D:/springImg/profile/10"
        makeFolders(basePath); //(폴더가 없을 수 있기 때문에)폴더를 만들어준다.
        File saveFile = new File(basePath, fileNm);


        //saveFile.exists(); //false 아직까지 파일이 존재하지 않는다.

        try {
            mf.transferTo(saveFile);
            return fileNm;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

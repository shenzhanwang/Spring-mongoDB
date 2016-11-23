package controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSON;
import pagemodel.PicGrid;
import po.Picture;
import service.PicService;
@Controller
public class PicController {
	@Autowired
	private PicService picservice;
	@RequestMapping(value="/piclist",produces = {"application/json;charset=UTF-8"}  )
	@ResponseBody
	public String getpiclist(@RequestParam int current,@RequestParam int rowCount) throws Exception{
		List<Picture> list=picservice.getpiclist(current,rowCount);
		PicGrid grid=new PicGrid();
		grid.setCurrent(current);
		grid.setRowCount(rowCount);
		grid.setTotal(picservice.getpicsize());
		grid.setRows(list);
		return JSON.toJSONString(grid);
	}
	
	@RequestMapping("/showpic")
	public String showactor(){
		return "showpic";
	}
	
	@RequestMapping("/uploadfile")
	public String fileupload(@RequestParam MultipartFile file,HttpServletRequest request){
		try{
			String filename=file.getOriginalFilename();
			List<String> type=new ArrayList<String>();
			type.add("image/png");
			type.add("image/jpeg");
			type.add("image/bmp");
			type.add("application/pdf");
			String filetype=file.getContentType();
			if(type.indexOf(filetype)==-1)
				return "typeror";
			if(file.getSize()>=16793600)
				return "filetoolarge";
			Picture p=new Picture(filename,file.getSize(),file.getBytes());
			picservice.addmongo(p);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "showpic";
	}
	
	@RequestMapping("/getpic")
	public void get(@RequestParam("id") String id ,HttpServletResponse response) throws Exception{
		InputStream is=picservice.getpic(id);
//		response.setContentType("image/png");
		ServletOutputStream output = response.getOutputStream();
		IOUtils.copy(is, output);
	} 
	
}

package com.inspur.gift.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.inspur.gift.util.exception.GiftBusinessException;

public class ImportOperation {

	/**
	 * Log4j日志记录对象.
	 */
	private static final Log LOGGER = LogFactory.getLog(ImportOperation.class);

	/**
	 * 创建ImportOperation对象
	 */
	private static ImportOperation instance = null;

	/**
	 * XSSFWorkbook对象
	 */
    private XSSFWorkbook wb;
    
    /**
	 * XSSFSheet对象
	 */
    private XSSFSheet sheet;
    
    /**
	 * XSSFRow对象
	 */
    private XSSFRow row;

    public static ImportOperation getInstance() throws GiftBusinessException {
    	Lock lock = new ReentrantLock();
        try {
            if (instance == null) {
            	lock.lock();
            	if (instance == null) {
            		instance = new ImportOperation();
            	}
            }
            return instance;
        } catch (Exception e) {
        	LOGGER.error("获取导入生日员工名单出错！");
            e.printStackTrace();
            throw new GiftBusinessException(e.getMessage(), e);
        } finally {
        	lock.unlock();
        }
    }
    
    public List<Map<String, String>> importMsg() throws GiftBusinessException{
    	List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
//			String filePath =
//					Thread.currentThread().getContextClassLoader().getResource("").getPath() + "生日名单.xlsx";
//			filePath = StringUtils.replace(filePath, "WEB-INF/classes", "");
			String filePath = "E:\\workspaces\\inspur.gift\\WebContent\\生日名单.xlsx";
            InputStream  is = new FileInputStream(filePath);

//			String filePath = System.getProperty("user.dir").replace("\\", "/") + "/";
			// 对读取Excel表格内容测试
//			InputStream  is = new FileInputStream(filePath + "生日名单.xlsx");
			Map<Integer, String> map = readExcelContent(is);
	        for (int i = 2; i <= map.size(); i++) {
	            String[] strs = map.get(i).split(",");
	            Map<String, String> peopleMsg = new HashMap<String, String>();
	            System.out.println(strs[3] + "==" + strs[7]);
	            peopleMsg.put("employeeId", strs[0]);
	            peopleMsg.put("bumen", strs[1]);
	            peopleMsg.put("bumen2", strs[2]);
	            peopleMsg.put("userName", strs[3]);
	            peopleMsg.put("sex", strs[4]);
	            peopleMsg.put("birthday", strs[5]);
	            peopleMsg.put("workPlace", strs[6]);
	            peopleMsg.put("mailBox", strs[7]);
	            list.add(peopleMsg);
	        }
	        return list;
		} catch (Exception e) {
			LOGGER.info("导入生日人员名单出错！");
			e.printStackTrace();
			throw new GiftBusinessException(e.getMessage(), e);
		}
    }

    public List<Map<String, String>> importOrder() throws GiftBusinessException{
    	List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
//			String filePath =
//					Thread.currentThread().getContextClassLoader().getResource("").getPath() + "生日名单.xlsx";
//			filePath = StringUtils.replace(filePath, "WEB-INF/classes", "");
			String filePath = "E:\\workspaces\\inspur.gift\\WebContent\\order.xlsx";
            InputStream  is = new FileInputStream(filePath);

//			String filePath = System.getProperty("user.dir").replace("\\", "/") + "/";
			// 对读取Excel表格内容测试
//			InputStream  is = new FileInputStream(filePath + "生日名单.xlsx");
			Map<Integer, String> map = readExcelContent(is);
	        for (int i = 2; i <= map.size(); i++) {
	            String[] strs = map.get(i).split(",");
	            Map<String, String> peopleMsg = new HashMap<String, String>();
	            peopleMsg.put("bumen", strs[1]);
	            peopleMsg.put("bumen2", strs[2]);
	            peopleMsg.put("userName", strs[3]);
	            peopleMsg.put("mailBox", strs[4]);
	            list.add(peopleMsg);
	        }
	        return list;
		} catch (Exception e) {
			LOGGER.info("导入生日人员名单出错！");
			e.printStackTrace();
			throw new GiftBusinessException(e.getMessage(), e);
		}
    }

//    读取xlsx 数据
//  　　InputStream fs 
//  　　XSSFWorkbook workbook = new XSSFWorkbook(fs);
//    读取xls 数据
//  　　HSSFWorkbook workbook = new HSSFWorkbook(fs);
    
    /**
     * 读取Excel表格表头的内容
     * @param InputStream
     * @return String 表头内容的数组
     * @throws GiftBusinessException 
     * @throws IOException 
     */
    public String[] readExcelTitle(InputStream is) throws GiftBusinessException{
        try {
            wb = new XSSFWorkbook(is);
        } catch (IOException e) {
        	throw new GiftBusinessException(e.getMessage(), e);
        }
        XSSFSheet sheet1 = (XSSFSheet) wb.getSheetAt(0);
        XSSFRow row1 = sheet1.getRow(0);
        // 标题总列数
        int colNum = row1.getPhysicalNumberOfCells();
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            //title[i] = getStringCellValue(row.getCell((short) i));
            title[i] = getCellFormatValue(row.getCell((short) i));
        }
        return title;
    }

    /**
     * 读取Excel数据内容
     * @param InputStream
     * @return Map 包含单元格数据内容的Map对象
     * @throws GiftBusinessException 
     * @throws Exception 
     */
    public Map<Integer, String> readExcelContent(InputStream is) throws GiftBusinessException{
        Map<Integer, String> content = new HashMap<Integer, String>();
        String str = "";
        try {
            wb = new XSSFWorkbook(is);
        } catch (IOException e) {
        	throw new GiftBusinessException(e.getMessage(), e);
        }
       
        sheet = wb.getSheetAt(0);
        
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第三行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            while (j < colNum) {
                // 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
                // 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
                // str += getStringCellValue(row.getCell((short) j)).trim() +
                // "-";
                str += getCellFormatValue(row.getCell((short) j)).trim() + ",";
                j++;
            }
            content.put(i, str);
            str = "";
        }
        return content;
    }

    /**
     * 获取单元格数据内容为字符串类型的数据
     * 
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    private String getStringCellValue(HSSFCell cell) {
        String strCell = "";
        switch (cell.getCellType()) {
        case HSSFCell.CELL_TYPE_STRING:
            strCell = cell.getStringCellValue();
            break;
        case HSSFCell.CELL_TYPE_NUMERIC:
            strCell = String.valueOf(cell.getNumericCellValue());
            break;
        case HSSFCell.CELL_TYPE_BOOLEAN:
            strCell = String.valueOf(cell.getBooleanCellValue());
            break;
        case HSSFCell.CELL_TYPE_BLANK:
            strCell = "";
            break;
        default:
            strCell = "";
            break;
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        if (cell == null) {
            return "";
        }
        return strCell;
    }

    /**
     * 获取单元格数据内容为日期类型的数据
     * 
     * @param cell
     *            Excel单元格
     * @return String 单元格数据内容
     * @throws GiftBusinessException 
     */
    private String getDateCellValue(HSSFCell cell) throws GiftBusinessException {
        String result = "";
        try {
            int cellType = cell.getCellType();
            if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
                Date date = cell.getDateCellValue();
                result = (date.getYear() + 1900) + "-" + (date.getMonth() + 1)
                        + "-" + date.getDate();
            } else if (cellType == HSSFCell.CELL_TYPE_STRING) {
                String date = getStringCellValue(cell);
                result = date.replaceAll("[年月]", "-").replace("日", "").trim();
            } else if (cellType == HSSFCell.CELL_TYPE_BLANK) {
                result = "";
            }
        } catch (Exception e) {
            LOGGER.error("日期格式不正确!");
            throw new GiftBusinessException(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 根据XSSFCell类型设置数据
     * @param cell
     * @return
     */
    private String getCellFormatValue(XSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC
            case XSSFCell.CELL_TYPE_NUMERIC:
            case XSSFCell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 如果是Date类型则，转化为Data格式
                    
                    //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                    //cellvalue = cell.getDateCellValue().toLocaleString();
                    
                    //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellvalue = sdf.format(date);
                    
                }
                // 如果是纯数字
                else {
                    // 取得当前Cell的数值
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            // 如果当前Cell的Type为STRIN
            case XSSFCell.CELL_TYPE_STRING:
                // 取得当前的Cell字符串
                cellvalue = cell.getRichStringCellValue().getString();
                break;
            // 默认的Cell值
            default:
                cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }
}

package com.stock.StockMarket;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
//import java.sql.Date;
//import java.time.LocalDate;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path="/demo", method= {RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST})
public class MainController {

//  List<String> files = new ArrayList<String>();
//	   private final Path rootLocation = Paths.get("C:\\Users\\Mounica\\Desktop");
  @Autowired 
  private UserRepository adminRepository;
  
  @Autowired
  private CompanyRepository company;
  
  @Autowired
  private StockPriceRepository price;
  
  @Autowired
  private IPORepository ipo;
 
  @Autowired
  private SectorRepository sector;
  
  @Autowired
  private StockExchangeRepository exchange;
  
  public int filenum=0;
  public Date date1;

//  @RequestMapping("/user")
//  public Principal user(Principal user) {
//	  System.out.println(user);
//    return user;
//  }

  @PostMapping("/users")
  public String addUser(@RequestBody User user) {
	  User user1 = adminRepository.getByEmail(user.getEmail());
	  if(user1==null) {
      adminRepository.save(user);
      return "sucess";}
	  else {return "false";}
  }
  
  @PostMapping("/company")
  public @ResponseBody Company getCompany(@RequestBody Company company1) {
	  try {
	  Company comp = company.findByCompname(company1.getCompname());
	  return comp;
	  }catch(Exception e) {
		  
	  }
	  return null;
  }
  
  @PostMapping("/checkadmin")
  public @ResponseBody String adminLogin(@RequestBody User user) {
	  User user1 = adminRepository.getByEmailAndPassword(user.getEmail(),user.getPassword());
	  if(user1!=null && user1.getUser_type().equals("admin")) {
		  System.out.print("success");
		  return "sucess";
	  }
	  else {
		  return "failed";
	  }
	  
  }
  
  @PostMapping("/profile")
  public @ResponseBody User userProfile(@RequestBody User user) {
	  User user1 = adminRepository.getByEmailAndPassword(user.getEmail(),user.getPassword());
	  return user1;
//	  if(user1!=null && user1.getUser_type().equals("user")) {
//		  System.out.println(12);
//		  return "sucess";
//	  }
//	  else {
//		  System.out.println(34);
//		  return "failed";
//	  }
	  
  }
  
  @PostMapping("/checkuser")
  public @ResponseBody String userLogin(@RequestBody User user) {
	  User user1 = adminRepository.getByEmailAndPassword(user.getEmail(),user.getPassword());
	  if(user1!=null && user1.getUser_type().equals("user")) {
		  System.out.println(12);
		  return "sucess";
	  }
	  else {
		  System.out.println(34);
		  return "failed";
	  }
	  
  }
  
  @PostMapping("/file")
  public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
     String message="";
     try {
        try {
        	//FileInputStream fis = new FileInputStream(file);
        	XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream()); 
        	XSSFSheet sheet = wb.getSheetAt(0);
        	Iterator<Row> itr = sheet.iterator();
        	Row row1 = itr.next();
        	while (itr.hasNext() )                 
        	{ 
        	StockPrice s1=new StockPrice();
        	Row row = itr.next();
        	Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
        	//while (cellIterator.hasNext())   
        	//{ 
        	    Cell cell = cellIterator.next();  
        		s1.setCompanycode(cell.getStringCellValue());
        		Cell cell1 = cellIterator.next();
        		s1.setStockexchange(cell1.getStringCellValue());
        		Cell cell2 = cellIterator.next();
        		s1.setCurrentprice(cell2.getNumericCellValue());
        		Cell cell3 = cellIterator.next();
        		//java.sql.Date sqlDate = new java.sql.Date( cell3.getDateCellValue() );
        		s1.setDate(cell3.getDateCellValue() );
//        		java.util.Date d = new java.util.Date();
//        		java.sql.Date sd = new java.sql.Date(cell3.getDateCellValue());
        		cell3.getDateCellValue();
        		//java.util.Date date = cell.getDateCellValue();
        		//java.sql.Date sqlDate = new java.sql.Date(date);
//        		java.sql.Date sqlDate = new java.sql.Date( cell3.getDateCellValue() );
//        		s1.setDate(cell3.getDateCellValue());
      		    Cell cell4 = cellIterator.next();
       		    s1.setTime(cell4.getStringCellValue());
      
//        		
        	price.save(s1);
        	}
        }
        	catch(Exception e)  
        	{  
        	e.printStackTrace();
        } 
        return ResponseEntity.status(HttpStatus.OK).body(message);
     } catch (Exception e) {
        message = "Failed to upload!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
     }
  }

  @GetMapping(path="/alluser")
  public @ResponseBody Iterable<User> getAlluser() {
    return adminRepository.findAll();
  }
  @PostMapping(path="/adduser1")          
  public @ResponseBody String addNewUser (@RequestBody User user1) {
    
    adminRepository.save(user1);
    return "Saved";
  }
  
  @GetMapping(path="/adduser")
  public @ResponseBody void getuser() {
   System.out.println("success");
  }
  @GetMapping(path="/byid/{id}")
  public @ResponseBody User getById(@PathVariable Integer id) {
    return adminRepository.findById(id).get();
  }
   
  
  @GetMapping(path="/bytype/{user_type}")
  public @ResponseBody List<String> getByuser(@PathVariable String user_type ) {
    return adminRepository.findByuser_type(user_type);
  }
  
  @PostMapping(path="/addcom")          
  public @ResponseBody String addNewCompany(@RequestBody Company company1) {
    
    company.save(company1);
    return "Saved";
  }

  @PutMapping(path="/updatecom")          
  public @ResponseBody String update(@RequestBody Company updatecompany) {
    
    company.save(updatecompany);
    return "Updated";
  }
  
  @PutMapping(path="/updateprofile")          
  public @ResponseBody String update(@RequestBody User updateuser) {
	  System.out.print("profile");
    adminRepository.save(updateuser);
    return "Updated";
  }
  
  @DeleteMapping(path="/deletecom/{id}")          
  public @ResponseBody String Delete(@PathVariable Integer id) {
    
    company.deleteById(id);
    return "Updated";
  }

  @GetMapping(path="/allcom")
  public @ResponseBody Iterable<Company> getAllCompany() {
    return company.findAll();
  }
  
  @PostMapping(path="/addstock")          
  public @ResponseBody String addNewStock (@RequestBody StockPrice stock1) {
    
    price.save(stock1);
    return "Saved";
  }

  @GetMapping(path="/allstock")
  public @ResponseBody Iterable<StockPrice> getAllstock() {
    return price.findAll();
  }
  
  @PostMapping(path="/addipo")                  
  public @ResponseBody String addNewIpo(@RequestBody IPO ipo1) {
    System.out.print(ipo1.getComp_name());
    ipo.save(ipo1);
    return "Saved";
  }

  @GetMapping(path="/allipo")
  public @ResponseBody Iterable<IPO> getAllipo() {
	  Date date=new Date();
	  try {
	  SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
	  //System.out.print(dateformat.format(date));
	 String dt=dateformat.format(date);
	 Date date2 = dateformat.parse(dt);
	 return ipo.findAllByOpendateGreaterThan(date2);
	  }catch(Exception e) {
		  
	  }
    return null;
  }
  
  @PostMapping(path="/addsector")                   
  public @ResponseBody String addNewSector(@RequestBody Sector sector1) {
    
    sector.save(sector1);
    return "Saved";
  }
  @GetMapping(path="/allsector")
  public @ResponseBody Iterable<Sector> getAllSector() {
    return sector.findAll();
  }
  
  @PostMapping(path="/addexchange")          
  public @ResponseBody String addNewExchange (@RequestParam String brief
      , @RequestParam String remarks) {
    StockExchange n5 = new StockExchange();
    n5.setBrief(brief);
    n5.setRemarks(remarks);
    exchange.save(n5); 
    return "Saved";
  } 

  @GetMapping(path="/allexchange")
  public @ResponseBody Iterable<StockExchange> getAllExchange() {
    return exchange.findAll();
  }
  
  @GetMapping(path="/map")
  public @ResponseBody Iterable<StockPrice> getMapprice(@RequestBody StockPriceDTO stock) {
	Company com = company.findStockcodeByCompnameAndStockexchange(stock.getCompany_name(),stock.getStock_exchange());
	//return price.findAll();
	return price.findAllByCompanycodeAndDateBetween(com.getStockcode()+" ",stock.getFromDate(),stock.getToDate());
   //return "";//price.findAll();
	
  }
  
  @DeleteMapping(path="/delete/{id}")
  public @ResponseBody String deleteById(@PathVariable Integer id ) {
    exchange.deleteById(id);
    return "deleted";
  }
  
  @GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public Login validateLogin() {
		return new Login("User successfully authenticated");
	}
 
  }
  

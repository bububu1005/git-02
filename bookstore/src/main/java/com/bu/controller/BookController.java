package com.bu.controller;

import com.bu.entity.Book;
import com.bu.entity.Class;
import com.bu.service.BookService;
import com.bu.service.ClassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ClassService classService;

    @RequestMapping("/getBook")// @RequestParam(defaultValue = "1")
    public String getBook(Model model,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize){
        //引入分页查询，使用PageHelper分页功能在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pageNum,1);
        PageInfo<Book> pageInfo = bookService.getBook();
        model.addAttribute("bookList",pageInfo);
        System.out.println(pageInfo);

        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        return "after/book_manager";
    }

    /*@RequestMapping("/getBook")
    public String getBook(Model model){
        //没分页
        List<Book> pageBook = bookService.getBook();
        model.addAttribute("bookList",pageBook);
        return "after/book_manager";
    }*/

    @RequestMapping("/toAddBook")
    public String toAddBook(Model model,Integer id){
        if(id!=null){
            Book book = bookService.getById(id);
            model.addAttribute("book",book);
        }else{
            Book book=new Book();
            model.addAttribute("book",book);
        }
        List<Class> allClass = classService.getAllClass();
        model.addAttribute("classList",allClass);
        return "after/add_book";
    }
    @RequestMapping("/addBook")
    public String addBook(Model model,Book book){
        if(book.getId()!=null && !book.getId().equals("")){
            bookService.update(book);
        }else {
            bookService.addBook(book);
        }
        return "redirect:/book/getBook";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        bookService.delete(id);
        return "redirect:/book/getBook";
    }
    /*---------------*/
    @RequestMapping("/getByCid")
    @ResponseBody
    public String getByCid(Integer cid){
        //删除前查询类型
        List<Book> bookList = bookService.getByCid(cid);
        if(bookList!=null){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/showBook")
    public String showBook(Model model,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize){
        //前端book页面
        PageHelper.startPage(pageNum,3);
        PageInfo<Book> pageInfo = bookService.getBook();
        model.addAttribute("bookList",pageInfo);
        System.out.println(pageInfo);

        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        /*List<Book> bookList = bookService.getBook();
        model.addAttribute("bookList",bookList);*/
        return "before/show_book";
    }

    @RequestMapping("/showBookByCid")
    public String showBookByCid(Model model,Integer cid,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize){
        //前端book页面
        PageHelper.startPage(pageNum,1);
        List<Book> bookList = bookService.getByCid(cid);
        PageInfo pageInfo = new PageInfo<Book>(bookList, 1);
        model.addAttribute("bookList",pageInfo);
        System.out.println(pageInfo);


        model.addAttribute("cid",cid);
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());


        /*List<Book> bookList = bookService.getByCid(cid);
        model.addAttribute("bookList",bookList);*/
        return "before/show_book";
    }
}

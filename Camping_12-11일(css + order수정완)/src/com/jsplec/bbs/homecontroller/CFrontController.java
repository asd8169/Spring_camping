package com.jsplec.bbs.homecontroller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.command.CAddcartCommand;
import com.jsplec.bbs.command.CAdminOrderListCommand;
import com.jsplec.bbs.command.CAdminQnaCommand;
import com.jsplec.bbs.command.CAdminWriteCommand;
import com.jsplec.bbs.command.CCartCommand;
import com.jsplec.bbs.command.CCartlistCommand;
import com.jsplec.bbs.command.CCommand;
import com.jsplec.bbs.command.CContentCommand;
import com.jsplec.bbs.command.CDeleteAllcartCommand;
import com.jsplec.bbs.command.CDeleteCommand;
import com.jsplec.bbs.command.CDeletecartCommand;
import com.jsplec.bbs.command.CFindIdCommand;
import com.jsplec.bbs.command.CFindPwCommand;
import com.jsplec.bbs.command.CFrontCommand;
import com.jsplec.bbs.command.CListCommand;
import com.jsplec.bbs.command.CLoginCommand;
import com.jsplec.bbs.command.CMainCommand;
import com.jsplec.bbs.command.CModifyCommand;
import com.jsplec.bbs.command.CMyReviewCommand;
import com.jsplec.bbs.command.CMyReviewDeleteCommand;
import com.jsplec.bbs.command.CMyReviewModifyCommand;
import com.jsplec.bbs.command.COrderCommand;
import com.jsplec.bbs.command.COrderListCommand;
import com.jsplec.bbs.command.CProductCommand;
import com.jsplec.bbs.command.CProductCommand0;
import com.jsplec.bbs.command.CProductCommand2;
import com.jsplec.bbs.command.CProductUploadCommand;
import com.jsplec.bbs.command.CPurchaseCommand;
import com.jsplec.bbs.command.CQnaCommand;
import com.jsplec.bbs.command.CQnaCommentCommand;
import com.jsplec.bbs.command.CQnaDeleteCommand;
import com.jsplec.bbs.command.CQnaModifyCommand;
import com.jsplec.bbs.command.CQnaViewCommand;
import com.jsplec.bbs.command.CQnaWriteCommand;
import com.jsplec.bbs.command.CRecUpdateCommand;
import com.jsplec.bbs.command.CReviewCommand;
import com.jsplec.bbs.command.CReviewDeleteCommand;
import com.jsplec.bbs.command.CReviewModifyCommand;
import com.jsplec.bbs.command.CReviewUploadCommand;
import com.jsplec.bbs.command.CReviewWriteCommand;
import com.jsplec.bbs.command.CSearchCommand;
import com.jsplec.bbs.command.CSearchProductCommand;
import com.jsplec.bbs.command.CSignUpCommand;
import com.jsplec.bbs.command.CUpdatecartCommand;
import com.jsplec.bbs.command.CUserIdCheckCommand;
import com.jsplec.bbs.command.CUserInfoCommand;
import com.jsplec.bbs.command.CUserInfoDeleteCommand;
import com.jsplec.bbs.command.CUserInfoLoadCommand;
import com.jsplec.bbs.command.CUserInfoUpdateCommand;
import com.jsplec.bbs.command.CWishCommand;
import com.jsplec.bbs.command.CWishDeleteCommand;
import com.jsplec.bbs.command.CWishlistCommand;
import com.jsplec.bbs.command.CWriteCommand;


/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")	// do로 끝나는건 내가 다 처리한다
public class CFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //protected 보안상 가장 높음
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("doGet");
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); 	// Post로 들어와도 doGet을 실행
		
		//System.out.println("doPost");
		actionDo(request,response);
	}
	
	
	//--------------------------
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("actionDo");
		
		request.setCharacterEncoding("utf-8");
	
		String uri = request.getRequestURI();
//		System.out.println(uri);
//		/201124/aaa.do
		
		String conPath = request.getContextPath();
//		System.out.println(conPath);
//		/201124
		
		String com = uri.substring(conPath.length());
//		System.out.println(com);
		
		HttpSession session =request.getSession();
		
		
		CCommand command = null;
		String viewPage = null;
		
		switch (com) {
		
		// 새로 만들 부분
//		//-------------------------------------------------------------
//		case("/sign_up.do"): // 회원가입 후 정보 db저장하고 front 화면으로 이동
//			command = new CSignupCommand();
//			command.execute(request, response, session);
//			viewPage = "front_view.jsp";
//			
//			break;
			
		//예진누나 ------------------------------------------------------
		//회원가입 --------------------------------------------------------------
			
		case("/joinform.do"): // 회원가입 폼 이동 (이후 커맨드 추가)
			viewPage = "signup_view.jsp";
			break;
		case("/idcheckaction.do"): //아이디 중복 체크
			command = new CUserIdCheckCommand();
			command.execute(request, response, session);
			viewPage = "front_view.jsp";
			break;
		case("/sign_up.do"): // 회원가입
			command = new CSignUpCommand();
			command.execute(request, response, session);
			viewPage = "front_view.jsp";
			break;
			
		//---P I W----  CLoginCommand ---------> CMainCommand로 변경
		//Paging CMainDto,CMainDao,main_view,CMainCommand로 확인하세요!
		
		case("/login.do"): // 로그인 성공 후 메인으로 이동
			command = new CLoginCommand();
			command.execute(request, response, session);
			
			int loginResult = (int) session.getAttribute("loginResult");
			String id = (String) session.getAttribute("sessionuserId");
			System.out.println("id : " + id);
			viewPage = "main.do";
			if (id.equals("admin")){
				System.out.println("id들어갔니?" + id);
				if (loginResult == 1) {	
					viewPage = "admin_main.jsp";
				} else {

					viewPage = "login_view.jsp";
					
				}
			}else{
				System.out.println("id여기로 들어갔니?" + id);
				if (loginResult == 1) {	
					viewPage = "main.do";
				} else {
					viewPage = "login_view.jsp";
					
			}
			}
			break;
			
			
		//12월 2일 인우 추가--------------------------------	
		//ID찾기
		case("/findId.do"): 
			//Id찾는 커맨드
			command = new CFindIdCommand();
			command.execute(request, response, session);
			viewPage = "findId.jsp";
			break;		
			
		//PW찾기		
		case("/findPw.do"): 
			command = new CFindPwCommand();
			command.execute(request, response, session);
			viewPage = "findPw.jsp";
		break;		
			
		
		// 로그인 성공 후 메인으로 이동
		case("/main.do"): 
			command = new CMainCommand();
			command.execute(request, response, session);
			viewPage = "main_view.jsp";
		break;
		
		// 메인화면에서 menu 클릭시 상품정보별 페이징
		case("/menu.do"): 
			command = new CSearchProductCommand();
			command.execute(request, response, session);
			viewPage = "main_view.jsp";
		break;
			
		
		//----------------admin command-------------------
		//admin 유저정보 조회 command
		case("/userinfo.do"): 
		command = new CUserInfoCommand();
		command.execute(request, response, session);
		viewPage = "userinfo_view.jsp";
		break;		
		
		
		//admin 유저정보 검색 페이징 command
		case("/userinfoSearch.do"): 
		command = new CSearchCommand();
		command.execute(request, response, session);
		viewPage = "userinfo_view.jsp";
		break;		
		
		
		//admin창에서 유저정보 삭제하는 command
		case("/userInfoDelete.do"): 
		command = new CUserInfoDeleteCommand();
		command.execute(request, response, session);
		viewPage = "userinfo.do";
		break;		
		
		
		//MYPAGE에서 유저정보 불러오는 command
		case("/userinfoLoad.do"): 
		command = new CUserInfoLoadCommand();
		command.execute(request, response, session);
		viewPage = "userinfo_update.jsp";
		
		break;		
		
		
		//MYPAGE에서 유저정보 수정하는 command
		case("/userinfoUpdate.do"): 
		command = new CUserInfoUpdateCommand();
		command.execute(request, response, session);
		viewPage = "main.do";
		
		break;		
		
		
		//-----------------------------------
		// 리뷰 (예진)--------------------------------------------------------------
		case ("/reviewlist.do"): // 리뷰 목록
			command = new CReviewCommand();
			command.execute(request, response, session);
			viewPage = "review_list.jsp";
			break;
			
			
			
		case ("/review_view.do"): // 리뷰 보기
			command = new CReviewCommand();
			command.execute(request, response, session);
			viewPage = "review_view.jsp";
			break;
			
			
		case ("/review_write.do"): // 리뷰 작성 폼 (이후 커맨드 추가)
//			viewPage = "reviewWrite.jsp"; //비효율 
			viewPage = "review_write.jsp"; // 효율
			break;
			
			
		case ("/regiseter_review.do"): // 리뷰 작성 완료
			
			command = new CReviewUploadCommand(); // 파일 서버 업로드
			command.execute(request, response, session);
			command = new CReviewWriteCommand(); // DB 저장 커맨드
			command.execute(request, response, session);
			viewPage = "myreviewlist.do";
			break;
			
			
			
		case ("/review_modify.do"): // 리뷰 수정 (커맨드 추가)
			command = new CReviewModifyCommand();
			command.execute(request, response, session);
			viewPage = "product.do";
			break;
			
			
		case ("/review_delelte.do"): // 리뷰 삭제(커맨드 추가)
			command = new CReviewDeleteCommand();
			command.execute(request, response, session);
			viewPage = "reviewlist.do";
			break;
			
			// 업로드 구현 (예진) --------------------------------------------------------------
		case("/upload.do"): // 업로드 rnd
			viewPage = "/board/uploadForm.jsp";
			break;
			//---------------------1210추가
			
			
			case("/product_write.do"): // 상품 작성 폼
				viewPage = "product_write.jsp";
				
			break;
					
				
			case("/register_product.do"): // 상품 등록
				command = new CProductUploadCommand(); // 상품 파일 서버 업로드
				command.execute(request, response, session);
//				command = new CAdminWriteCommand(); // DB 저장 커맨드
//				command.execute(request, response, session);
				viewPage = "register_product1.do";
				break;
				
				
			case("/register_product1.do"): // 상품 등록
				command = new CAdminWriteCommand(); // DB 저장 커맨드
				command.execute(request, response, session);
				viewPage = "/product_list.do";
			break;
				
				
			
			case("/product_list.do"): // admin 상품관리 리스트
				
				//이름바꾸기
				command = new CProductCommand2();
				command.execute(request, response, session);
				viewPage = "admin_Product_list.jsp";
				
			break;
		//---(종한)----------------------------------------------------------------------------
		
			// 제품 상세화면에서 쓰는 3개 버튼 command
			// -----------------------------------------------------------------------------------------	
			case ("/product0.do"): 
				
			command = new CProductCommand0();
			command.execute(request, response, session);
			viewPage = "product.do";

			break;
			
			
			case("/product.do"): // 제품 상세화면으로 들어가는 command

				command = new CProductCommand();
				command.execute(request, response, session);
				
				
				//리뷰리스트 띄우기
				command = new CReviewCommand();
				command.execute(request, response, session);
				
				
//				QNA리스트 띄우기
				command = new CQnaCommand();
				command.execute(request, response, session);
				
				viewPage = "product_view.jsp";
			
				break;
				
				
				
			case("/cart.do"): // 제품 상세화면에서 즉시 구매를 눌렀을 때. 해당 제품이 cart에 추가되고 cart를 보여준다
				command = new CAddcartCommand();
				command.execute(request, response, session); // 현재 제품과 수량을 장바구니에 추가
				command = new CWishlistCommand();
				command.execute(request, response, session);
				
				viewPage = "cartlist.do";
				break;
			case("/addcart.do"): // 장바구니에 넣기
				command = new CAddcartCommand();
				command.execute(request, response, session);
				viewPage = "product.do"; 
				break;
			case("/recUpdate.do"): // 위시리스트 추가 or 삭제
				command = new CRecUpdateCommand();
				command.execute(request, response, session);
				viewPage = "product.do"; 
				break;	
			
				
			// 즉시구매 이후 (장바구니 + 위시리스트) 창
			// -----------------------------------------------------------------------------------------
			case("/cartlist.do"): // cart용 searchAction 느낌(장바구니에서 삭제, 위시리스트에서 삭제, 수량 변경시 사용)
				command = new CCartlistCommand();
				command.execute(request, response, session); // 장바구니 리스트를 불러옴
				command = new CWishlistCommand();
				command.execute(request, response, session);
				viewPage = "cart_view.jsp";
				break;	
				
			case("/updatecart.do"): // 직접구매 -> 장바구니 테이블에서 수량 변경
				command = new CUpdatecartCommand();
				command.execute(request, response, session);
				viewPage = "cartlist.do"; 
				break;
			case("/deletecart.do"): // 장바구니에서 삭제하기
				command = new CDeletecartCommand();
				command.execute(request, response, session);
				
				viewPage = "cartlist.do"; 
				break;
			case("/deleteAllcart.do"): // 장바구니 전부 삭제하기
				command = new CDeleteAllcartCommand();
				command.execute(request, response, session);
			
				viewPage = "cartlist.do"; 
				break;
			case("/deletewish.do"): // 위시리스트에서 삭제하기
				command = new CWishDeleteCommand();
				command.execute(request, response, session);
			
				viewPage = "cartlist.do"; 
				break;
				
				
			// wishlist 불러오기
			case("/wishlist.do"): // wishlist용 searchAction 느낌
				command = new CWishlistCommand();
				command.execute(request, response, session);
				viewPage = "wishlist_view.jsp";
				break;
					
			// 결제화면	
			// -----------------------------------------------------------------------------------------	
			case("/order.do"): 
				command = new CCartlistCommand();
				command.execute(request, response, session);
				command = new CUserInfoLoadCommand();
				command.execute(request, response, session);
				
				viewPage = "order_view.jsp"; //
				break;
				
			
				
				//MY PAGE(인우) -------------------------------------------------------------------------------
			case("/orderlist.do"): // 주문내역 리스트
				command = new COrderListCommand();
				command.execute(request, response, session);
				viewPage = "order_list.jsp"; //
				break;
			//MY PAGE(예진) -------------------------------------------------------------------------------
			case("/myreviewlist.do"): // my review 내역 불러오기
				command = new CMyReviewCommand();
				command.execute(request, response, session);
				viewPage = "myreview_list.jsp";
				break;
			case ("/myreview_view.do"): // 리뷰 보기
				command = new CMyReviewCommand();
				command.execute(request, response, session);
				viewPage = "myreview_view.jsp";
				break;
			case ("/myreview_modify.do"): // 리뷰 수정 (커맨드 추가)
				command = new CMyReviewModifyCommand();
				command.execute(request, response, session);
				viewPage = "myreviewlist.do";
				break;
			case ("/myreview_delelte.do"): // 리뷰 삭제(커맨드 추가)
				command = new CMyReviewDeleteCommand();
				command.execute(request, response, session);
				viewPage = "myreviewlist.do";
				break;
			
			
			// Admin Page OrderList-----------------------------------------------------------------------------------------	
			case("/admin_order_list.do"): 
			command = new CAdminOrderListCommand();
			command.execute(request, response, session);
			viewPage = "admin_order_list.jsp"; //
			break;	
				
				
			
			
			
			
		// 결제화면에서 최종 주문하기 버튼 눌렀을 때 -> 카카오페이 -> 여기
		case ("/purchase.do"):
			command = new CPurchaseCommand();
			command.execute(request, response, session);
			command = new CDeleteAllcartCommand();
			command.execute(request, response, session);

			viewPage = "purchaseSuccess_view.jsp"; // 결제 완료 후 메인으로 이동
			break;
		// 201127 세미추가
		//-------------------------------------------------------------	
			
		case("/qna.do"): // 
			command = new CQnaCommand();
			command.execute(request, response, session);
			viewPage = "product.do"; 
			break;
			
		case("/qnaAdmin.do"): // 
			command = new CAdminQnaCommand();
			command.execute(request, response, session);
			viewPage = "admin_qna_list.jsp"; 
			break;
			
			
		case ("/qna_write.do"): // qna 글작성 등록
			command = new CQnaWriteCommand();
			command.execute(request, response, session);
			viewPage = "qna.do";
			break;
				
				
			// 201130 세미추가	
		case("/qna_view.do"):	// 내용보기
			command = new CQnaViewCommand();
			command.execute(request, response, session);
			viewPage = "qna_view.jsp";
			break;
				
			// 201201 세미추가
		case ("/qnamodify.do"): // 내용수정
			command = new CQnaModifyCommand();
			command.execute(request, response, session);
			viewPage = "qna.do";
			break;

		case ("/qnadelete.do"): // 삭제
			command = new CQnaDeleteCommand();
			command.execute(request, response, session);
			viewPage = "qna.do";
			break;

		// 201203 세미추가
		case ("/qnaComment.do"): // qna댓글 작성 등록
			command = new CQnaCommentCommand();
			command.execute(request, response, session);
			viewPage = "qnaAdmin.do";
			break;

//		// 201204 세미추가
//		case ("/product_list.do"): // admin 상품 리스트
//			command = new CProductCommand();
//			command.execute(request, response, session);
//			viewPage = "admin_Product_list.jsp";
//			break;
//		
//		// 201204 세미추가
//		case ("/plist_modify.do"): // admin 상품 리스트 수정
//			command = new CProductModifyCommand();
//			command.execute(request, response, session);
//			viewPage = "product_list.do";
//			break;
//
//		case ("/admin_order_list.do"): // order list 출력
//			command = new COrderListCommand();
//			command.execute(request, response, session);
//			viewPage = "admin_order_list.jsp";
//			
//			break;

//		// -------------------------------------------------------------
//			
//		case("/review.do"): // 
//			command = new CReviewCommand();
//			command.execute(request, response, session);
//			viewPage = "review_view.jsp";
//			break;
//			
//		case("/wish.do"): // 
//			command = new CWishCommand();
//			command.execute(request, response, session);
//			viewPage = "wish_view.jsp"; 
//			break;
//		//-------------------------------------------------------------
//		case("/write_view.do"):
//			viewPage = "write_view.jsp";
//			break;
//		case("/write.do"):
//			command = new CWriteCommand();
//			command.execute(request, response, session);
//			viewPage = "write_view.do"; 
//			break;
//		
//		case("/content_view.do"):	// 내용보기
//			command = new CContentCommand();
//			command.execute(request, response, session);
//			viewPage = "content_view.jsp";
//			break;
//		case("/modify.do"):		//수정
//			command = new CModifyCommand();
//			command.execute(request, response, session);
//			viewPage = "list.do";
//			break;
//		case("/delete.do"):		//삭제
//			command = new CDeleteCommand();
//			command.execute(request, response, session);
//			viewPage = "list.do";
//			break;
//		default:
//			viewPage = "list.do";
//			break;
		}
		
		Enumeration<String> se = session.getAttributeNames();
		
		while(se.hasMoreElements()){
			
			String getse = se.nextElement()+"";
			
			System.out.println("@@@@@@@ session : "+getse+" : " + session.getAttribute(getse));
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}

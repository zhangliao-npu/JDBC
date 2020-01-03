public class AddressServlet extends HttpServlet {
// 注入dao
private AddressDao addressDao = new AddressDao();

protected void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {
//设置编码，很重要，否则页面提交，中文会出现乱码
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("utf-8");
//设置路径
      String path = "list.jsp";
      String method = request.getParameter("method");
//若请求的url有list
  if (("list").equals(method)) {
      List<Address> list = addressDao.findAll();
      request.setAttribute("list", list);
    }
   else if (method.equals("add")) {
//注入Address实体类
   Address address = new Address();
//获取参数
      String name = request.getParameter("name");
      String street = request.getParameter("street");
      String city = request.getParameter("city");
      String state = request.getParameter("state");
      String zip = request.getParameter("zip");
//设置增加的属性
      address.setName(name);
      address.setStreet(street);
      address.setCity(city);
      address.setState(state);
      address.setZip(zip);
      addressDao.add(address);
<!--把新加入的数据重新加载,这点特别重要，否则刷新页面会报空指针异常-->
      path = "AddressServlet?method=list";
    }

    else if (method.equals("delete")) {

//根据id来删除
      int id = Integer.parseInt(request.getParameter("id"));
      addressDao.delete(id);
//要重新查询一遍，否则会报空指针
      path = "AddressServlet?method=list";
    }
//跳转编辑页面url请求如下：
    else if (method.equals("toedit")) {
      int id = Integer.parseInt(request.getParameter("id"));
      Address address = addressDao.findById(id);
      path = "edit.jsp";
      request.setAttribute("address", address);
    }

    else if (method.equals("edit")) {

//根据id修改
      int id = Integer.parseInt(request.getParameter("id"));
      String name = request.getParameter("name");
      String street = request.getParameter("street");
      String city = request.getParameter("city");
      String state = request.getParameter("state");
      String zip = request.getParameter("zip");

      Address address = new Address();
      address.setId(id);
      address.setName(name);
      address.setStreet(street);
      address.setCity(city);
      address.setState(state);
      address.setZip(zip);

      addressDao.update(address);
//把新加入的数据重新加载
      path = "AddressServlet?method=list";
 }
      request.getRequestDispatcher(path).forward(request, response);
}

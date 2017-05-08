package controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.util.HSSFColor.DARK_BLUE;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userName;

	public void preRender() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request = ((HttpServletRequest) context.getRequest());

		if ("true".equals(request.getParameter("invalid"))) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuário ou senha inválidos!", "menssagem para usuario ou senha invalidos" ));
		}
	}

	public void login() throws IOException, ServletException {

		try {
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest request = ((HttpServletRequest) context.getRequest());
			ServletResponse resposnse = ((ServletResponse) context.getResponse());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
			dispatcher.forward(request, resposnse);
			FacesContext.getCurrentInstance().responseComplete();

		} catch (Exception ex) {
			ex.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nome de usuário ou senha inválidos"));
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}

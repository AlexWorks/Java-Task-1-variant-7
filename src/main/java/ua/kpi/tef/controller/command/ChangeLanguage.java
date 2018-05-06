package ua.kpi.tef.controller.command;

import ua.kpi.tef.TextConstants;
import ua.kpi.tef.controller.bundlemanager.BundleManager;
import ua.kpi.tef.controller.enums.Language;
import ua.kpi.tef.model.Model;

import javax.servlet.http.HttpServletRequest;

public class ChangeLanguage implements Command {
    @Override
    public String execute(HttpServletRequest request, Model model) {
        try {
            String languageStr = request.getParameter(TextConstants.LANGUAGE);
            Language language = Language.getLanguage(languageStr);
            BundleManager.changeLanguage(language);
        } catch (Exception e) {}
        return TextConstants.DEFAULT_PAGE;
    }
}

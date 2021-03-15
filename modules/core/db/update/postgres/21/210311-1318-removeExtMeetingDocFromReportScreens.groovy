import com.haulmont.cuba.core.EntityManager
import com.haulmont.cuba.core.Persistence
import com.haulmont.cuba.core.Transaction
import com.haulmont.cuba.core.TypedQuery
import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.reports.ReportingApi
import com.haulmont.reports.entity.Report
import com.haulmont.reports.entity.ReportScreen
import org.apache.commons.collections.CollectionUtils

postUpdate.add({
    AppBeans.get(Persistence.class).createTransaction().execute(new Transaction.Callable() {
        @Override
        Object call(EntityManager em) {
            ReportingApi reportingApi = AppBeans.get(ReportingApi.class);
            TypedQuery<Report> reportQuery = em.createQuery("select r from report\$Report r", Report.class);
            List<Report> reports = reportQuery.getResultList();
            for (Report report : reports) {
                Report reportFromXml = reportingApi.convertToReport(report.getXml());
                List<ReportScreen> reportScreens = reportFromXml.getReportScreens();
                if (CollectionUtils.isNotEmpty(reportScreens)) {
                    List<ReportScreen> screens = reportScreens.findAll() {
                        'thesistest$MeetingDoc.edit'.equals(it.screenId) ||
                        'thesistest$MeetingDoc.lookup'.equals(it.screenId) ||
                        'thesistest$MeetingDoc.browse'.equals(it.screenId)
                    }
                    reportScreens.removeAll(screens)
                    reportFromXml.setReportScreens(reportScreens);
                    report.setXml(reportingApi.convertToXml(reportFromXml));
                }
            }
            
            return true;
        }
    });
})

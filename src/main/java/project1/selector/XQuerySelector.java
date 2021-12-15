package project1.selector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import com.saxonica.xqj.SaxonXQDataSource;

public class XQuerySelector {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      try {
         execute();
      }

      catch (FileNotFoundException e) {
         e.printStackTrace();
      }

      catch (XQException e) {
         e.printStackTrace();
      }
   }

   private static void execute() throws FileNotFoundException, XQException {
      InputStream inputStream = new FileInputStream(new File("selector.xqy"));
      XQDataSource ds = new SaxonXQDataSource();
      XQConnection conn = ds.getConnection();
      XQPreparedExpression exp = conn.prepareExpression(inputStream);
      XQResultSequence result = exp.executeQuery();

      try (PrintWriter p = new PrintWriter(new FileOutputStream("xmlAfterXQYSelector.xml", false))) {
         p.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
         while (result.next()) {
            p.println(result.getItemAsString(null));
         }

      } catch (FileNotFoundException e1) {
         e1.printStackTrace();
      }
   }
}

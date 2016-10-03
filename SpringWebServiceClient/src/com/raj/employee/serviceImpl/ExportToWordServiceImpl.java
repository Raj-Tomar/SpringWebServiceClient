package com.raj.employee.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.BreakClear;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFStyle;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STStyleType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;
import org.springframework.stereotype.Service;

@Service
public class ExportToWordServiceImpl {

	
	@SuppressWarnings("deprecation")
	public void exportMsWordParagraphs(String fileName, String filePath){
		
		//Blank Document
		XWPFDocument doc = new XWPFDocument(); 

		try {
			//create Paragraphs
			XWPFParagraph p1 = doc.createParagraph();
			p1.setAlignment(ParagraphAlignment.CENTER);
			p1.setBorderBottom(Borders.DOUBLE);
			p1.setBorderTop(Borders.DOUBLE);

			p1.setBorderRight(Borders.DOUBLE);
			p1.setBorderLeft(Borders.DOUBLE);
			p1.setBorderBetween(Borders.SINGLE);

			p1.setVerticalAlignment(TextAlignment.TOP);
			
			XWPFRun r1 = p1.createRun();
	        r1.setBold(true);
	        r1.setText("The quick brown fox");
	        r1.setBold(true);
	        r1.setFontFamily("Courier");
	        r1.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
	        r1.setTextPosition(100);
	        
	        XWPFParagraph p2 = doc.createParagraph();
	        p2.setAlignment(ParagraphAlignment.RIGHT);

	        //BORDERS
	        p2.setBorderBottom(Borders.DOUBLE);
	        p2.setBorderTop(Borders.DOUBLE);
	        p2.setBorderRight(Borders.DOUBLE);
	        p2.setBorderLeft(Borders.DOUBLE);
	        p2.setBorderBetween(Borders.SINGLE);

	        XWPFRun r2 = p2.createRun();
	        r2.setText("jumped over the lazy dog");
	        r2.setStrike(true);
	        r2.setFontSize(20);
	        
	        XWPFRun r3 = p2.createRun();
	        r3.setText("and went away");
	        r3.setStrike(true);
	        r3.setFontSize(20);
	        r3.setSubscript(VerticalAlign.SUPERSCRIPT);


	        XWPFParagraph p3 = doc.createParagraph();
	        p3.setWordWrap(true);
	        p3.setPageBreak(true);
	        
	      //p3.setAlignment(ParagraphAlignment.DISTRIBUTE);
	        p3.setAlignment(ParagraphAlignment.BOTH);
	        p3.setSpacingLineRule(LineSpacingRule.EXACT);

	        p3.setIndentationFirstLine(600);
	        
	        XWPFRun r4 = p3.createRun();
	        r4.setTextPosition(20);
	        r4.setText("To be, or not to be: that is the question: "
	                + "Whether 'tis nobler in the mind to suffer "
	                + "The slings and arrows of outrageous fortune, "
	                + "Or to take arms against a sea of troubles, "
	                + "And by opposing end them? To die: to sleep; ");
	        r4.addBreak(BreakType.PAGE);
	        r4.setText("No more; and by a sleep to say we end "
	                + "The heart-ache and the thousand natural shocks "
	                + "That flesh is heir to, 'tis a consummation "
	                + "Devoutly to be wish'd. To die, to sleep; "
	                + "To sleep: perchance to dream: ay, there's the rub; "
	                + ".......");
	        r4.setItalic(true);
	        
	      //This would imply that this break shall be treated as a simple line break, and break the line after that word:

	        XWPFRun r5 = p3.createRun();
	        r5.setTextPosition(-10);
	        r5.setText("For in that sleep of death what dreams may come");
	        r5.addCarriageReturn();
	        r5.setText("When we have shuffled off this mortal coil,"
	                + "Must give us pause: there's the respect"
	                + "That makes calamity of so long life;");
	        r5.addBreak();
	        r5.setText("For who would bear the whips and scorns of time,"
	                + "The oppressor's wrong, the proud man's contumely,");
	        
	        r5.addBreak(BreakClear.ALL);
	        r5.setText("The pangs of despised love, the law's delay,"
	                + "The insolence of office and the spurns" + ".......");
			
	      //Write the Document in file system
		  FileOutputStream out = new FileOutputStream(filePath + File.separator + new File(fileName));
	        
			doc.write(out);
			doc.close();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exportImagesInWord(String fileName, String filePath){
		XWPFDocument doc = new XWPFDocument();
		XWPFParagraph p = doc.createParagraph();

		XWPFRun r = p.createRun();

		String args[] = {"C:/Documents and Settings/Administrator/Desktop/New Folder/bike.jpg",
						"C:/Documents and Settings/Administrator/Desktop/New Folder/yamaha.jpg",
						"C:/Documents and Settings/Administrator/Desktop/New Folder/iphone 6.jpg"};

		try {
			for(String imgFile : args) {
				int format;
				if(imgFile.endsWith(".emf")) format = XWPFDocument.PICTURE_TYPE_EMF;
				else if(imgFile.endsWith(".wmf")) format = XWPFDocument.PICTURE_TYPE_WMF;
				else if(imgFile.endsWith(".pict")) format = XWPFDocument.PICTURE_TYPE_PICT;
				else if(imgFile.endsWith(".jpeg") || imgFile.endsWith(".jpg")) format = XWPFDocument.PICTURE_TYPE_JPEG;
				else if(imgFile.endsWith(".png")) format = XWPFDocument.PICTURE_TYPE_PNG;
				else if(imgFile.endsWith(".dib")) format = XWPFDocument.PICTURE_TYPE_DIB;
				else if(imgFile.endsWith(".gif")) format = XWPFDocument.PICTURE_TYPE_GIF;
				else if(imgFile.endsWith(".tiff")) format = XWPFDocument.PICTURE_TYPE_TIFF;
				else if(imgFile.endsWith(".eps")) format = XWPFDocument.PICTURE_TYPE_EPS;
				else if(imgFile.endsWith(".bmp")) format = XWPFDocument.PICTURE_TYPE_BMP;
				else if(imgFile.endsWith(".wpg")) format = XWPFDocument.PICTURE_TYPE_WPG;
				else {
					System.err.println("Unsupported picture: " + imgFile +
							". Expected emf|wmf|pict|jpeg|png|dib|gif|tiff|eps|bmp|wpg");
					continue;
				}
				r.setText(imgFile);
				r.addBreak();
				r.addPicture(new FileInputStream(imgFile), format, imgFile, Units.toEMU(200), Units.toEMU(200)); // 200x200 pixels
				r.addBreak(BreakType.PAGE);
				
			}
			// Write the file
			FileOutputStream out = new FileOutputStream(filePath + File.separator + new File(fileName));
			doc.write(out);
			doc.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exportMsWordSimpleTable(String fileName, String filePath){
		try {
			createSimpleTable(fileName, filePath);
		}
		catch(Exception e) {
			System.out.println("Error trying to create simple table.");
		}
		
	}
	
	public void exportMsWordStyledTable(String fileName, String filePath){
		try {
			createStyledTable(fileName, filePath);
		}
		catch(Exception e) {
			System.out.println("Error trying to create styled table.");
		}
	}
	
	public void exportMsWordSampleTable(String fileName, String filePath){
		// Create a new document from scratch
		XWPFDocument doc = new XWPFDocument();
		// Set Margins of the document
		CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();
	    CTPageMar pageMar = sectPr.addNewPgMar();
	    pageMar.setLeft(BigInteger.valueOf(1500L));
	    pageMar.setRight(BigInteger.valueOf(1500L));
	    pageMar.setTop(BigInteger.valueOf(2000L));
	    pageMar.setBottom(BigInteger.valueOf(1000L));
		
		// Header and Footer
		XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(doc, sectPr);
		
		try {
			
			
			//write header content
			CTP ctpHeader = CTP.Factory.newInstance();
			CTR ctrHeader = ctpHeader.addNewR();
			CTText ctHeader = ctrHeader.addNewT();
			String headerText = "Sample Report";
			ctHeader.setStringValue(headerText);	
			XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, doc);
			headerParagraph.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun headerRun = headerParagraph.createRun();
			headerRun.setUnderline(UnderlinePatterns.THICK);
			
			
			XWPFParagraph[] parsHeader = new XWPFParagraph[1];
			parsHeader[0] = headerParagraph;
			parsHeader[0].setBorderBottom(Borders.BASIC_THIN_LINES);
			policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);

			//write footer content
			/*
			CTP ctpFooter = CTP.Factory.newInstance();
			CTR ctrFooter = ctpFooter.addNewR();
			CTText ctFooter = ctrFooter.addNewT();
			SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy");
			String footerText = "Report Generation Date: "+dateFormate.format(new Date());
			ctFooter.setStringValue(footerText);
			XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, doc);
			footerParagraph.setAlignment(ParagraphAlignment.LEFT);
			
			XWPFParagraph[] parsFooter = new XWPFParagraph[1];
			parsFooter[0] = footerParagraph;
			policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);
			*/
			
			/*
			// create footer
			CTP ctpFooter = CTP.Factory.newInstance();

			XWPFParagraph[] parsFooter;

			// add style (s.th.)
			CTPPr ctppr = ctpFooter.addNewPPr();
			CTString pst = ctppr.addNewPStyle();
			pst.setVal("style21");
			CTJc ctjc = ctppr.addNewJc();
			ctjc.setVal(STJc.RIGHT);
			ctppr.addNewRPr();

			// add everything from the footerXXX.xml you need
			CTR ctrFooter = ctpFooter.addNewR();
			CTText ctFooter = ctrFooter.addNewT();
			SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy");
			String footerText = "Report Generation Date: "+dateFormate.format(new Date())+" Page No: ";
			ctFooter.setStringValue(footerText);
			
			
			CTR ctr = ctpFooter.addNewR();
			ctr.addNewRPr();
			CTFldChar fch = ctr.addNewFldChar();
			fch.setFldCharType(STFldCharType.BEGIN);

			ctr = ctpFooter.addNewR();
			ctr.addNewInstrText().setStringValue(" PAGE ");

			ctpFooter.addNewR().addNewFldChar().setFldCharType(STFldCharType.SEPARATE);

			ctpFooter.addNewR().addNewT().setStringValue("1");

			ctpFooter.addNewR().addNewFldChar().setFldCharType(STFldCharType.END);

			XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, doc);

			parsFooter = new XWPFParagraph[1];

			parsFooter[0] = footerParagraph;
			parsFooter[0].setBorderTop(Borders.BASIC_THIN_LINES);

			policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);
			*/
			
			CTP footerCtp = CTP.Factory.newInstance();
		    CTR footerCtr = footerCtp.addNewR();
		    
		    
		    XWPFParagraph footerCopyrightParagraph = new XWPFParagraph(footerCtp, doc);
		    footerCopyrightParagraph.setBorderTop(Borders.BASIC_THIN_LINES);
		    doc.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();
		    XWPFRun footerParaRun = footerCopyrightParagraph.getRun(footerCtr);
		    SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy");
			String footerDate = "Report Generation Date: "+dateFormate.format(new Date());
			footerParaRun.setText(footerDate);
			footerParaRun.addTab();
		    //run.setText("\u00A9" + " My Website - " + Calendar.getInstance().get(Calendar.YEAR));
		    //run.addTab();
			footerParaRun.setText("Page No: ");
		    
		    CTFldChar fch = footerCtr.addNewFldChar();
			fch.setFldCharType(STFldCharType.BEGIN);
			footerCtr = footerCtp.addNewR();
			footerCtr.addNewInstrText().setStringValue(" PAGE ");
			footerCtp.addNewR().addNewFldChar().setFldCharType(STFldCharType.SEPARATE);
			footerCtp.addNewR().addNewT().setStringValue("1");
			footerCtp.addNewR().addNewFldChar().setFldCharType(STFldCharType.END);
		    
			setTabStop(footerCtp, STTabJc.Enum.forString("right"), BigInteger.valueOf(9350));

		    XWPFParagraph[] footerParagraphs = {footerCopyrightParagraph};
		    XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(doc, sectPr);
		    headerFooterPolicy.createFooter(STHdrFtr.DEFAULT, footerParagraphs);
			
		    
			String heading1 = "My Heading 1";

			XWPFParagraph paragraph = doc.createParagraph();
			paragraph.setAlignment(ParagraphAlignment.CENTER);
			paragraph.setStyle(heading1);

			XWPFRun run = paragraph.createRun();
			run.setText("Sample Table");

			// -- OR --
			// open an existing empty document with styles already defined
			//XWPFDocument doc = new XWPFDocument(new FileInputStream("base_document.docx"));

			// Create a new table with 6 rows and 3 columns
			int nRows = 3;
			int nCols = 1;
			XWPFTable table = doc.createTable(nRows, nCols);

			// Set the table style. If the style is not defined, the table style
			// will become "Normal".
			CTTblPr tblPr = table.getCTTbl().getTblPr();
			CTString styleStr = tblPr.addNewTblStyle();
			styleStr.setVal("StyledTable");

			// Get a list of the rows in the table
			List<XWPFTableRow> rows = table.getRows();
			int rowCt = 0;
			int colCt = 0;


			for (XWPFTableRow row : rows) {
				// get table row properties (trPr)
				CTTrPr trPr = row.getCtRow().addNewTrPr();
				// set row height; units = twentieth of a point, 360 = 0.25"
				CTHeight ht = trPr.addNewTrHeight();
				ht.setVal(BigInteger.valueOf(360));

				// get the cells in this row
				List<XWPFTableCell> cells = row.getTableCells();
				// add content to each cell
				for (XWPFTableCell cell : cells) {
					// get a table cell properties element (tcPr)
					CTTcPr tcpr = cell.getCTTc().addNewTcPr();
					// set vertical alignment to "center"
					CTVerticalJc va = tcpr.addNewVAlign();
					va.setVal(STVerticalJc.CENTER);

					// Setting Width of Cell
					cell.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(3000));

					// create cell color element
					CTShd ctshd = tcpr.addNewShd();
					ctshd.setColor("auto");
					ctshd.setVal(STShd.CLEAR);
					if (rowCt % 2 == 0) {
						// even row
						ctshd.setFill("D3DFEE");
					} else {
						// odd row
						ctshd.setFill("EDF2F8");
					}

					// get 1st paragraph in cell's paragraph list
					XWPFParagraph para = cell.getParagraphs().get(0);
					// create a run to contain the content
					XWPFRun rh = para.createRun();
					// style cell as desired
					if (colCt == nCols - 1) {
						// last column is 10pt Courier
						rh.setFontSize(10);
						rh.setFontFamily("Courier");
					}
					rh.setText("Location Name: "+rowCt);
					rh.setBold(true);
					para.setAlignment(ParagraphAlignment.LEFT);
					rh.addBreak();

					rh.setText("Description: "+"xyz...");
					rh.setBold(true);
					para.setAlignment(ParagraphAlignment.LEFT);
					rh.addBreak();

					rh.setText("Images:");
					rh.setBold(true);
					para.setAlignment(ParagraphAlignment.LEFT);
					rh.addBreak();

					// Images
					XWPFRun imagePara = para.createRun();

					/*
						String args[] = {"C:/Documents and Settings/Administrator/Desktop/New Folder/bike.jpg",
								"C:/Documents and Settings/Administrator/Desktop/New Folder/yamaha.jpg",
								"C:/Documents and Settings/Administrator/Desktop/New Folder/iphone 6.jpg",};
					 */

					String args[] = {
							"http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg",
							"https://s-media-cache-ak0.pinimg.com/originals/9c/b3/f8/9cb3f845b24223556ed8b23a1b5c0e77.jpg",
							"http://st.depositphotos.com/1025727/4454/v/450/depositphotos_44541595-Chamomile-flowers-field.jpg"
					};

					try {
						int imgNo = 1;
						for(String imgFile : args) {

							int format;
							if(imgFile.endsWith(".emf")) format = XWPFDocument.PICTURE_TYPE_EMF;
							else if(imgFile.endsWith(".wmf")) format = XWPFDocument.PICTURE_TYPE_WMF;
							else if(imgFile.endsWith(".pict")) format = XWPFDocument.PICTURE_TYPE_PICT;
							else if(imgFile.endsWith(".jpeg") || imgFile.endsWith(".jpg")) format = XWPFDocument.PICTURE_TYPE_JPEG;
							else if(imgFile.endsWith(".png")) format = XWPFDocument.PICTURE_TYPE_PNG;
							else if(imgFile.endsWith(".dib")) format = XWPFDocument.PICTURE_TYPE_DIB;
							else if(imgFile.endsWith(".gif")) format = XWPFDocument.PICTURE_TYPE_GIF;
							else if(imgFile.endsWith(".tiff")) format = XWPFDocument.PICTURE_TYPE_TIFF;
							else if(imgFile.endsWith(".eps")) format = XWPFDocument.PICTURE_TYPE_EPS;
							else if(imgFile.endsWith(".bmp")) format = XWPFDocument.PICTURE_TYPE_BMP;
							else if(imgFile.endsWith(".wpg")) format = XWPFDocument.PICTURE_TYPE_WPG;
							else {
								System.err.println("Unsupported picture: " + imgFile +
										". Expected emf|wmf|pict|jpeg|png|dib|gif|tiff|eps|bmp|wpg");
								continue;
							}
							URL url = new URL(imgFile); 
							String tDir = System.getProperty("java.io.tmpdir"); 
							String path = tDir + "TempImage";
							System.out.println("Temp Path:\n"+path);
							File file = new File(path); 
							FileUtils.copyURLToFile(url, file);

							imagePara.setText(imgNo+")");
							imagePara.addBreak();
							imagePara.addPicture(new FileInputStream(file), format, imgFile, Units.toEMU(50), Units.toEMU(50)); // 50x50 pixels
							imagePara.addBreak();
							imgNo++;

							file.deleteOnExit();
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}

					colCt++;
				} // for cell
				colCt = 0;
				rowCt++;
			} // for row

			// write the file
			FileOutputStream out = new FileOutputStream(filePath + File.separator + new File(fileName));
			try {
				doc.write(out);
			} finally {
				out.close();
				doc.close();
			}
		} 
		catch(Exception e) {
			System.out.println("Error trying to create styled table.");
		}

	}
	
	
	
	
	public static void createSimpleTable(String fileName, String filePath) throws Exception {
        XWPFDocument doc = new XWPFDocument();

        try {
        	
        	// Creating Simple Table
            XWPFTable simpleTable = doc.createTable(3, 3);

            simpleTable.getRow(1).getCell(1).setText("EXAMPLE OF TABLE");

            // table cells have a list of paragraphs; there is an initial
            // paragraph created when the cell is created. If you create a
            // paragraph in the document to put in the cell, it will also
            // appear in the document following the table, which is probably
            // not the desired result.
            XWPFParagraph p1 = simpleTable.getRow(0).getCell(0).getParagraphs().get(0);

            XWPFRun r1 = p1.createRun();
            r1.setBold(true);
            r1.setText("The quick brown fox");
            r1.setItalic(true);
            r1.setFontFamily("Courier");
            r1.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
            r1.setTextPosition(100);
       
            simpleTable.getRow(2).getCell(2).setText("only text");
            
         // Creating Styled Table

            // write the file
            FileOutputStream out = new FileOutputStream(filePath + File.separator + new File(fileName));
            try {
                doc.write(out);
            } finally {
                out.close();
            }
        } finally {
            doc.close();
        }
    }
	
	
	/**
     * Create a table with some row and column styling. I "manually" add the
     * style name to the table, but don't check to see if the style actually
     * exists in the document. Since I'm creating it from scratch, it obviously
     * won't exist. When opened in MS Word, the table style becomes "Normal".
     * I manually set alternating row colors. This could be done using Themes,
     * but that's left as an exercise for the reader. The cells in the last
     * column of the table have 10pt. "Courier" font.
     * I make no claims that this is the "right" way to do it, but it worked
     * for me. Given the scarcity of XWPF examples, I thought this may prove
     * instructive and give you ideas for your own solutions.

     * @throws Exception
     */
    public static void createStyledTable(String fileName, String filePath) throws Exception {
    	// Create a new document from scratch
        XWPFDocument doc = new XWPFDocument();

        try {

        	XWPFStyles styles = doc.createStyles();

        	String heading1 = "My Heading 1";
        	String heading2 = "My Heading 2";
        	String heading3 = "My Heading 3";   
        	String heading4 = "My Heading 4";
        	addCustomHeadingStyle(doc, styles, heading1, 1, 36, "4288BC");
        	addCustomHeadingStyle(doc, styles, heading2, 2, 28, "4288BC");
        	addCustomHeadingStyle(doc, styles, heading3, 3, 24, "4288BC");
        	addCustomHeadingStyle(doc, styles, heading4, 4, 20, "000000");

        	XWPFParagraph paragraph = doc.createParagraph();
        	paragraph.setAlignment(ParagraphAlignment.CENTER);
        	paragraph.setStyle(heading1);
        	
        	XWPFRun run = paragraph.createRun();
        	run.setText("Sample Table");

        	// -- OR --
        	// open an existing empty document with styles already defined
        	//XWPFDocument doc = new XWPFDocument(new FileInputStream("base_document.docx"));

        	// Create a new table with 6 rows and 3 columns
        	int nRows = 3;
        	int nCols = 3;
        	XWPFTable table = doc.createTable(nRows, nCols);

        	// Set the table style. If the style is not defined, the table style
        	// will become "Normal".
        	CTTblPr tblPr = table.getCTTbl().getTblPr();
        	CTString styleStr = tblPr.addNewTblStyle();
        	styleStr.setVal("StyledTable");

        	// Get a list of the rows in the table
        	List<XWPFTableRow> rows = table.getRows();
        	int rowCt = 0;
        	int colCt = 0;


        	for (XWPFTableRow row : rows) {
        		// get table row properties (trPr)
        		CTTrPr trPr = row.getCtRow().addNewTrPr();
        		// set row height; units = twentieth of a point, 360 = 0.25"
        		CTHeight ht = trPr.addNewTrHeight();
        		ht.setVal(BigInteger.valueOf(360));

        		// get the cells in this row
        		List<XWPFTableCell> cells = row.getTableCells();
        		// add content to each cell
        		for (XWPFTableCell cell : cells) {
        			// get a table cell properties element (tcPr)
        			CTTcPr tcpr = cell.getCTTc().addNewTcPr();
        			// set vertical alignment to "center"
        			CTVerticalJc va = tcpr.addNewVAlign();
        			va.setVal(STVerticalJc.CENTER);

        			// Setting Width of Cell
        			cell.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(3000));

        			// create cell color element
        			CTShd ctshd = tcpr.addNewShd();
        			ctshd.setColor("auto");
        			ctshd.setVal(STShd.CLEAR);
        			if (rowCt == 0) {
        				// header row
        				ctshd.setFill("A7BFDE");
        			} else if (rowCt % 2 == 0) {
        				// even row
        				ctshd.setFill("D3DFEE");
        			} else {
        				// odd row
        				ctshd.setFill("EDF2F8");
        			}

        			// get 1st paragraph in cell's paragraph list
        			XWPFParagraph para = cell.getParagraphs().get(0);
        			// create a run to contain the content
        			XWPFRun rh = para.createRun();
        			// style cell as desired
        			if (colCt == nCols - 1) {
        				// last column is 10pt Courier
        				rh.setFontSize(10);
        				rh.setFontFamily("Courier");
        			}
        			if (rowCt == 0) {
        				// header row
        				rh.setText("Sample Text" + colCt);
        				rh.setBold(true);
        				para.setAlignment(ParagraphAlignment.CENTER);
        			} else {
        				// other rows
        				rh.setText("row " + rowCt + ", col " + colCt);
        				para.setAlignment(ParagraphAlignment.LEFT);
        			}
        			colCt++;
        		} // for cell
        		colCt = 0;
        		rowCt++;
        	} // for row

        	// write the file
        	FileOutputStream out = new FileOutputStream(filePath + File.separator + new File(fileName));
        	try {
        		doc.write(out);
        	} finally {
        		out.close();
        	}
        } finally {
            doc.close();
        }
    }
    
    
    private static void addCustomHeadingStyle(XWPFDocument docxDocument, XWPFStyles styles, String strStyleId, int headingLevel, int pointSize, String hexColor) {

        CTStyle ctStyle = CTStyle.Factory.newInstance();
        ctStyle.setStyleId(strStyleId);


        CTString styleName = CTString.Factory.newInstance();
        styleName.setVal(strStyleId);
        ctStyle.setName(styleName);

        CTDecimalNumber indentNumber = CTDecimalNumber.Factory.newInstance();
        indentNumber.setVal(BigInteger.valueOf(headingLevel));

        // lower number > style is more prominent in the formats bar
        ctStyle.setUiPriority(indentNumber);

        CTOnOff onoffnull = CTOnOff.Factory.newInstance();
        ctStyle.setUnhideWhenUsed(onoffnull);

        // style shows up in the formats bar
        ctStyle.setQFormat(onoffnull);

        // style defines a heading of the given level
        CTPPr ppr = CTPPr.Factory.newInstance();
        ppr.setOutlineLvl(indentNumber);
        ctStyle.setPPr(ppr);

        XWPFStyle style = new XWPFStyle(ctStyle);

        CTHpsMeasure size = CTHpsMeasure.Factory.newInstance();
        size.setVal(new BigInteger(String.valueOf(pointSize)));
        CTHpsMeasure size2 = CTHpsMeasure.Factory.newInstance();
        size2.setVal(new BigInteger("24"));

        CTFonts fonts = CTFonts.Factory.newInstance();
        fonts.setAscii("Loma" );

        CTRPr rpr = CTRPr.Factory.newInstance();
        rpr.setRFonts(fonts);
        rpr.setSz(size);
        rpr.setSzCs(size2);

        CTColor color=CTColor.Factory.newInstance();
        color.setVal(hexToBytes(hexColor));
        rpr.setColor(color);
        style.getCTStyle().setRPr(rpr);
        // is a null op if already defined

        style.setType(STStyleType.PARAGRAPH);
        styles.addStyle(style);

    }
   
    public static byte[] hexToBytes(String hexString) {
        HexBinaryAdapter adapter = new HexBinaryAdapter();
        byte[] bytes = adapter.unmarshal(hexString);
        return bytes;
   }
    
    private static void setTabStop(CTP oCTP, STTabJc.Enum oSTTabJc, BigInteger oPos) {
	    CTPPr oPPr = oCTP.getPPr();
	    if (oPPr == null) {
	        oPPr = oCTP.addNewPPr();
	    }

	    CTTabs oTabs = oPPr.getTabs();
	    if (oTabs == null) {
	        oTabs = oPPr.addNewTabs();
	    }

	    CTTabStop oTabStop = oTabs.addNewTab();
	    oTabStop.setVal(oSTTabJc);
	    oTabStop.setPos(oPos);
	}
}

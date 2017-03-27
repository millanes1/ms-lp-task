--LOAD TABLE LP_TOOL

/*INSERT INTO LINE_PLANNING.LP_TOOL(LPTL_CODE, LPTK_CODE,LPTL_CODE_MXI, LPTL_NAME, LPTL_QUANTITY) VALUES (1, 1,2,'TOOL_NAME1',12);
INSERT INTO LINE_PLANNING.LP_TOOL(LPTL_CODE, LPTK_CODE,LPTL_CODE_MXI, LPTL_NAME, LPTL_QUANTITY) VALUES (2, 1,3,'TOOL_NAME2',14);
INSERT INTO LINE_PLANNING.LP_TOOL(LPTL_CODE, LPTK_CODE,LPTL_CODE_MXI, LPTL_NAME, LPTL_QUANTITY) VALUES (3, 3,1,'TOOL_NAME3',12);
INSERT INTO LINE_PLANNING.LP_TOOL(LPTL_CODE, LPTK_CODE,LPTL_CODE_MXI, LPTL_NAME, LPTL_QUANTITY) VALUES (4, 3,3,'TOOL_NAME5',14);


--LOAD TABLE LP_WORK_PACKAGE
INSERT INTO LINE_PLANNING.LP_WORK_PACKAGE(LPWP_BARCODE, LPWP_NAME,LPWP_STATUS, LPWP_LOCATION,LPWP_DATE_TIME_START, LPWP_DATE_TIME_END ) VALUES ('BC1', 'WP1','OPEN','LOC1',NOW(),null);
INSERT INTO LINE_PLANNING.LP_WORK_PACKAGE(LPWP_BARCODE, LPWP_NAME,LPWP_STATUS, LPWP_LOCATION,LPWP_DATE_TIME_START, LPWP_DATE_TIME_END ) VALUES ('BC3', 'WP3','OPEN','LOC2',NOW(),NOW());
INSERT INTO LINE_PLANNING.LP_WORK_PACKAGE(LPWP_BARCODE, LPWP_NAME,LPWP_STATUS, LPWP_LOCATION,LPWP_DATE_TIME_START, LPWP_DATE_TIME_END ) VALUES ('BC4', 'WP4','OPEN','LOC1',NOW(),null);

--LOAD TABLE LP_AIRCRAFT

INSERT INTO LINE_PLANNING.LP_AIRCRAFT(LPAC_AC_REG_CD, LPAC_ASSMBL_CD,LPAC_AUTHORITY_CD, LPAC_OPERATOR_CD) VALUES ('TAIL1', 'FLEET1','AT1','OP1');
INSERT INTO LINE_PLANNING.LP_AIRCRAFT(LPAC_AC_REG_CD, LPAC_ASSMBL_CD,LPAC_AUTHORITY_CD, LPAC_OPERATOR_CD) VALUES ('TAIL2', 'FLEET1','AT2','OP3');
INSERT INTO LINE_PLANNING.LP_AIRCRAFT(LPAC_AC_REG_CD, LPAC_ASSMBL_CD,LPAC_AUTHORITY_CD, LPAC_OPERATOR_CD) VALUES ('TAIL3', 'FLEET2','AT3','OP4');
INSERT INTO LINE_PLANNING.LP_AIRCRAFT(LPAC_AC_REG_CD, LPAC_ASSMBL_CD,LPAC_AUTHORITY_CD, LPAC_OPERATOR_CD) VALUES ('TAIL4', 'FLEET2','AT4','OP1');


--LOAD TABLE LP_TASK

INSERT INTO LINE_PLANNING.LP_TASK(LPTK_CODE, LPTK_BARCODE,LPTK_CODE_MXI, LPAC_AC_REG_CD,LPWP_BARCODE,LPTK_NAME,LPTK_STATUS, LPTK_TASK_TYPE,LPTK_DUE_DATE,LPTK_DUE_DATE_EXT,LPTK_DUE_DATE_FNL,LPTK_YIELD, LPTK_DURATION, LPTK_BARCODE_DVR,LPTK_DUE_DATE_DVR,LPTK_PRIORITY,LPTK_SCHED_STATUS)VALUES (1,'BARCODE_TK_1',3,'TAIL1','BC1','LPTK_NAME','OPEN','TYPE',NOW(),null,NOW(),12,233,null,null,1,'OPEN');


INSERT INTO LINE_PLANNING.LP_TASK(LPTK_CODE, LPTK_BARCODE,LPTK_CODE_MXI, LPAC_AC_REG_CD,LPWP_BARCODE,LPTK_NAME,LPTK_STATUS, LPTK_TASK_TYPE,LPTK_DUE_DATE,LPTK_DUE_DATE_EXT,LPTK_DUE_DATE_FNL,LPTK_YIELD, LPTK_DURATION, LPTK_BARCODE_DVR,LPTK_DUE_DATE_DVR,LPTK_PRIORITY,LPTK_SCHED_STATUS)VALUES (2,'BARCODE_TK_2',2,'TAIL1','BC3','LPTK_NAME_1','OPEN','TYPE',NOW(),null,NOW(),12,933,null,null,1,'OPEN');


INSERT INTO LINE_PLANNING.LP_TASK(LPTK_CODE, LPTK_BARCODE,LPTK_CODE_MXI, LPAC_AC_REG_CD,LPWP_BARCODE,LPTK_NAME,LPTK_STATUS, LPTK_TASK_TYPE,LPTK_DUE_DATE,LPTK_DUE_DATE_EXT,LPTK_DUE_DATE_FNL,LPTK_YIELD, LPTK_DURATION, LPTK_BARCODE_DVR,LPTK_DUE_DATE_DVR,LPTK_PRIORITY,LPTK_SCHED_STATUS)VALUES (3,'BARCODE_TK_3',4,'TAIL2','BC4','LPTK_NAME_2','OPEN','TYPE',NOW(),null,NOW(),12,999,null,null,1,'OPEN');


--LOAD TABLE LP_LABOUR
INSERT INTO LINE_PLANNING.LP_LABOUR(LPLB_CODE, LPTK_CODE, LPLB_SKILL,LPLB_MAN_REQUIRED,LPLB_MAN_HR) VALUES(1,1,'SKILL1',23,3332);
INSERT INTO LINE_PLANNING.LP_LABOUR(LPLB_CODE, LPTK_CODE, LPLB_SKILL,LPLB_MAN_REQUIRED,LPLB_MAN_HR) VALUES(2,1,'SKILL2',99,122);

INSERT INTO LINE_PLANNING.LP_LABOUR(LPLB_CODE, LPTK_CODE, LPLB_SKILL,LPLB_MAN_REQUIRED,LPLB_MAN_HR) VALUES(3,2,'SKILL1',233,3321);
INSERT INTO LINE_PLANNING.LP_LABOUR(LPLB_CODE, LPTK_CODE, LPLB_SKILL,LPLB_MAN_REQUIRED,LPLB_MAN_HR) VALUES(4,3,'SKILL2',939,1232);



--LOAD TABLE LP_PART
INSERT INTO LINE_PLANNING.LP_PART(LPPT_CODE, LPTK_CODE, LPPT_CODE_MXI,LPPT_CODE_MXI_GROUP,LPPT_STATUS,LPPT_NAME,LPPT_QUANTITY, LPPT_DATE_ETA ) VALUES(1,1,2,3,'OPEN','NAME1',32,NOW());
INSERT INTO LINE_PLANNING.LP_PART(LPPT_CODE, LPTK_CODE, LPPT_CODE_MXI,LPPT_CODE_MXI_GROUP,LPPT_STATUS,LPPT_NAME,LPPT_QUANTITY, LPPT_DATE_ETA ) VALUES(2,1,2,3,'OPEN','NAME2',323,NOW());
INSERT INTO LINE_PLANNING.LP_PART(LPPT_CODE, LPTK_CODE, LPPT_CODE_MXI,LPPT_CODE_MXI_GROUP,LPPT_STATUS,LPPT_NAME,LPPT_QUANTITY, LPPT_DATE_ETA ) VALUES(3,1,4,3,'OPEN','NAME3',34,NOW());*/



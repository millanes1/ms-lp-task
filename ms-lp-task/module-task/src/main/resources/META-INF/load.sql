INSERT INTO public.REST_DB_TASKS(TASK_ID,WRPK_ID, TASK_NAME) VALUES (1,1,'TASK1');
INSERT INTO public.REST_DB_TASKS(TASK_ID,WRPK_ID, TASK_NAME) VALUES (2,2,'TASK2');
INSERT INTO public.REST_DB_TASKS(TASK_ID,WRPK_ID, TASK_NAME) VALUES (3,2,'TASK3');
INSERT INTO public.REST_DB_TASKS(TASK_ID,WRPK_ID, TASK_NAME) VALUES (4,3,'TASK5');


INSERT INTO public.REST_DB_TOOLS(TOOL_ID,TASK_ID,TOOL_NAME) VALUES (1,2,'TOOL1');
INSERT INTO public.REST_DB_TOOLS(TOOL_ID,TASK_ID,TOOL_NAME) VALUES (2,3,'TOOL2');
INSERT INTO public.REST_DB_TOOLS(TOOL_ID,TASK_ID,TOOL_NAME) VALUES (3,3,'TOOL3');
INSERT INTO public.REST_DB_TOOLS(TOOL_ID,TASK_ID,TOOL_NAME) VALUES (4,1,'TOOL4');


--LOAD TABLE LP_WORK_PACKAGE
INSERT INTO public.LP_WORK_PACKAGE(LPWP_BARCODE, LPWP_NAME,LPWP_STATUS, LPWP_LOCATION,LPWP_DATE_TIME_START, LPWP_DATE_TIME_END ) VALUES ('BC1', 'WP1','OPEN','LOC1',NOW(),null);
INSERT INTO public.LP_WORK_PACKAGE(LPWP_BARCODE, LPWP_NAME,LPWP_STATUS, LPWP_LOCATION,LPWP_DATE_TIME_START, LPWP_DATE_TIME_END ) VALUES ('BC3', 'WP3','OPEN','LOC2',NOW(),NOW());
INSERT INTO public.LP_WORK_PACKAGE(LPWP_BARCODE, LPWP_NAME,LPWP_STATUS, LPWP_LOCATION,LPWP_DATE_TIME_START, LPWP_DATE_TIME_END ) VALUES ('BC4', 'WP4','OPEN','LOC1',NOW(),null);

--LOAD TABLE LP_AIRCRAFT

INSERT INTO public.LP_AIRCRAFT(LPAC_AC_REG_CD, LPAC_ASSMBL_CD,LPAC_AUTHORITY_CD ) VALUES ('TAIL1', 'FLEET1','OPT1');
INSERT INTO public.LP_AIRCRAFT(LPAC_AC_REG_CD, LPAC_ASSMBL_CD,LPAC_AUTHORITY_CD ) VALUES ('TAIL2', 'FLEET1','OPT3');
INSERT INTO public.LP_AIRCRAFT(LPAC_AC_REG_CD, LPAC_ASSMBL_CD,LPAC_AUTHORITY_CD ) VALUES ('TAIL3', 'FLEET2','OPT4');
INSERT INTO public.LP_AIRCRAFT(LPAC_AC_REG_CD, LPAC_ASSMBL_CD,LPAC_AUTHORITY_CD ) VALUES ('TAIL4', 'FLEET2','OPT1');
























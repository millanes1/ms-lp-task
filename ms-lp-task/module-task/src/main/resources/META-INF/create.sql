CREATE TABLE public.LP_TOOL(LPTL_CODE integer, LPTK_CODE integer,LPTL_CODE_MXI DECIMAL(10), LPTL_NAME VARCHAR(80),LPTL_QUANTITY FLOAT(53));

CREATE TABLE public.LP_WORK_PACKAGE(LPWP_BARCODE VARCHAR(80),LPWP_NAME VARCHAR(500),LPWP_STATUS VARCHAR(12),LPWP_LOCATION VARCHAR(2000),LPWP_DATE_TIME_START DATE,LPWP_DATE_TIME_END DATE);

CREATE TABLE public.LP_AIRCRAFT(LPAC_AC_REG_CD VARCHAR(10), LPAC_ASSMBL_CD VARCHAR(80), LPAC_AUTHORITY_CD VARCHAR (8));

CREATE TABLE public.LP_TASK(LPTK_CODE integer,LPTK_BARCODE VARCHAR(80),LPTK_CODE_MXI DECIMAL(10),LPAC_AC_REG_CD VARCHAR(10),LPWP_BARCODE VARCHAR(80),LPTK_NAME VARCHAR(500),LPTK_STATUS VARCHAR(12),LPTK_TASK_TYPE VARCHAR(16),LPTK_DUE_DATE DATE,LPTK_DUE_DATE_EXT DATE,LPTK_DUE_DATE_FNL DATE,LPTK_YIELD FLOAT(53),LPTK_DURATION FLOAT(53),LPTK_BARCODE_DVR VARCHAR(80),LPTK_DUE_DATE_DVR DATE,LPTK_PRIORITY DECIMAL(2),LPTK_SCHED_STATUS VARCHAR(30));


CREATE TABLE public.LP_LABOUR(LPLB_CODE integer, LPTK_CODE integer, LPLB_SKILL VARCHAR(12),LPLB_MAN_REQUIRED DECIMAL(10),LPLB_MAN_HR DECIMAL(6,2));

CREATE TABLE public.LP_PART(LPPT_CODE integer, LPTK_CODE integer, LPPT_CODE_MXI DECIMAL(10),LPPT_CODE_MXI_GROUP DECIMAL(10),LPPT_STATUS VARCHAR(12),LPTT_QUANTITY FLOAT(53), LPTT_DATE_ETA DATE);

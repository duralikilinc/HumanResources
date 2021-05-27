--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-27 12:56:16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16843)
-- Name: employers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employers (
    employer_id integer NOT NULL,
    company_name character varying(30) NOT NULL,
    company_website character varying(30) NOT NULL,
    first_name character varying(15) NOT NULL,
    last_name character varying(15) NOT NULL,
    phone character varying(15) NOT NULL,
    system_verify boolean NOT NULL
);


ALTER TABLE public.employers OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16874)
-- Name: job_positions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_positions (
    id integer NOT NULL,
    name character varying(30) NOT NULL
);


ALTER TABLE public.job_positions OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16872)
-- Name: job_position_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.job_positions ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."job_position_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 203 (class 1259 OID 16848)
-- Name: job_seekers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_seekers (
    job_seekers_id integer NOT NULL,
    first_name character varying(15) NOT NULL,
    last_name character varying(15) NOT NULL,
    tc_no character varying(11) NOT NULL,
    birth_year smallint NOT NULL
);


ALTER TABLE public.job_seekers OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16853)
-- Name: systemusers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.systemusers (
    admin_id integer NOT NULL,
    first_name character varying(15) NOT NULL,
    last_name character varying(15) NOT NULL,
    job_id integer NOT NULL
);


ALTER TABLE public.systemusers OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16838)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(50) NOT NULL,
    password character varying(15) NOT NULL,
    email_verify boolean NOT NULL,
    repeat_password character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16836)
-- Name: users_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."users_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2870 (class 2606 OID 16905)
-- Name: users email_uk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT email_uk UNIQUE (email) INCLUDE (email);


--
-- TOC entry 2881 (class 2606 OID 16878)
-- Name: job_positions job_position_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_positions
    ADD CONSTRAINT job_position_pkey PRIMARY KEY (id);


--
-- TOC entry 2874 (class 2606 OID 16852)
-- Name: job_seekers job_seekers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT job_seekers_pkey PRIMARY KEY (job_seekers_id);


--
-- TOC entry 2879 (class 2606 OID 16857)
-- Name: systemusers systemusers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.systemusers
    ADD CONSTRAINT systemusers_pkey PRIMARY KEY (admin_id);


--
-- TOC entry 2876 (class 2606 OID 16903)
-- Name: job_seekers uk_tc; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT uk_tc UNIQUE (tc_no) INCLUDE (tc_no);


--
-- TOC entry 2872 (class 2606 OID 16842)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2877 (class 1259 OID 16901)
-- Name: fki_fk_jobId; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fki_fk_jobId" ON public.systemusers USING btree (job_id);


--
-- TOC entry 2885 (class 2606 OID 16910)
-- Name: systemusers fk_jobposition; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.systemusers
    ADD CONSTRAINT fk_jobposition FOREIGN KEY (job_id) REFERENCES public.job_positions(id) NOT VALID;


--
-- TOC entry 2882 (class 2606 OID 16881)
-- Name: employers fk_userId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT "fk_userId" FOREIGN KEY (employer_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2883 (class 2606 OID 16886)
-- Name: job_seekers fk_userId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT "fk_userId" FOREIGN KEY (job_seekers_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2884 (class 2606 OID 16891)
-- Name: systemusers fk_userId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.systemusers
    ADD CONSTRAINT "fk_userId" FOREIGN KEY (admin_id) REFERENCES public.users(id) NOT VALID;


-- Completed on 2021-05-27 12:56:16

--
-- PostgreSQL database dump complete
--


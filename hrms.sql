--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-31 15:13:49

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
-- TOC entry 207 (class 1259 OID 17013)
-- Name: cities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cities (
    id integer NOT NULL,
    city_name character varying(255)
);


ALTER TABLE public.cities OWNER TO postgres;

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
-- TOC entry 209 (class 1259 OID 17020)
-- Name: job_advertisemens; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_advertisemens (
    id integer NOT NULL,
    description character varying(255),
    is_aktive boolean,
    last_date date,
    max_salary numeric(19,2),
    min_salary numeric(19,2),
    personel_number integer,
    city_id integer,
    employer_id integer,
    job_position_id integer
);


ALTER TABLE public.job_advertisemens OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 17018)
-- Name: job_advertisemens_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.job_advertisemens_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.job_advertisemens_id_seq OWNER TO postgres;

--
-- TOC entry 3040 (class 0 OID 0)
-- Dependencies: 208
-- Name: job_advertisemens_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.job_advertisemens_id_seq OWNED BY public.job_advertisemens.id;


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
-- TOC entry 2879 (class 2604 OID 17023)
-- Name: job_advertisemens id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisemens ALTER COLUMN id SET DEFAULT nextval('public.job_advertisemens_id_seq'::regclass);


--
-- TOC entry 2896 (class 2606 OID 17017)
-- Name: cities cities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cities
    ADD CONSTRAINT cities_pkey PRIMARY KEY (id);


--
-- TOC entry 2881 (class 2606 OID 16905)
-- Name: users email_uk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT email_uk UNIQUE (email) INCLUDE (email);


--
-- TOC entry 2885 (class 2606 OID 17037)
-- Name: employers employers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_pkey PRIMARY KEY (employer_id);


--
-- TOC entry 2898 (class 2606 OID 17025)
-- Name: job_advertisemens job_advertisemens_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisemens
    ADD CONSTRAINT job_advertisemens_pkey PRIMARY KEY (id);


--
-- TOC entry 2894 (class 2606 OID 16878)
-- Name: job_positions job_position_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_positions
    ADD CONSTRAINT job_position_pkey PRIMARY KEY (id);


--
-- TOC entry 2887 (class 2606 OID 16852)
-- Name: job_seekers job_seekers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT job_seekers_pkey PRIMARY KEY (job_seekers_id);


--
-- TOC entry 2892 (class 2606 OID 16857)
-- Name: systemusers systemusers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.systemusers
    ADD CONSTRAINT systemusers_pkey PRIMARY KEY (admin_id);


--
-- TOC entry 2889 (class 2606 OID 16903)
-- Name: job_seekers uk_tc; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT uk_tc UNIQUE (tc_no) INCLUDE (tc_no);


--
-- TOC entry 2883 (class 2606 OID 16842)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2890 (class 1259 OID 16901)
-- Name: fki_fk_jobId; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fki_fk_jobId" ON public.systemusers USING btree (job_id);


--
-- TOC entry 2902 (class 2606 OID 17026)
-- Name: job_advertisemens fk64p84eaonek7uhujv6t0tkg6k; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisemens
    ADD CONSTRAINT fk64p84eaonek7uhujv6t0tkg6k FOREIGN KEY (city_id) REFERENCES public.cities(id);


--
-- TOC entry 2899 (class 2606 OID 16881)
-- Name: employers fk_userId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT "fk_userId" FOREIGN KEY (employer_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2900 (class 2606 OID 16886)
-- Name: job_seekers fk_userId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT "fk_userId" FOREIGN KEY (job_seekers_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2901 (class 2606 OID 16891)
-- Name: systemusers fk_userId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.systemusers
    ADD CONSTRAINT "fk_userId" FOREIGN KEY (admin_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2904 (class 2606 OID 17038)
-- Name: job_advertisemens fkcx4i3x5q89j6mnb79txj9ln5l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisemens
    ADD CONSTRAINT fkcx4i3x5q89j6mnb79txj9ln5l FOREIGN KEY (employer_id) REFERENCES public.employers(employer_id);


--
-- TOC entry 2903 (class 2606 OID 17031)
-- Name: job_advertisemens fkoy80hyth0mx54cbfy8lbrmww9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisemens
    ADD CONSTRAINT fkoy80hyth0mx54cbfy8lbrmww9 FOREIGN KEY (job_position_id) REFERENCES public.job_positions(id);


-- Completed on 2021-05-31 15:13:49

--
-- PostgreSQL database dump complete
--


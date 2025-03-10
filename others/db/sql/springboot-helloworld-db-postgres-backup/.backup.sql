--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

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
-- Name: hello_worlds; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.hello_worlds (
    id bigint NOT NULL,
    text character varying(255) NOT NULL
);


ALTER TABLE public.hello_worlds OWNER TO admin;

--
-- Name: hello_worlds_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.hello_worlds_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.hello_worlds_seq OWNER TO admin;

--
-- Data for Name: hello_worlds; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.hello_worlds (id, text) FROM stdin;
1	Hello World!
\.


--
-- Name: hello_worlds_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.hello_worlds_seq', 1, true);


--
-- Name: hello_worlds hello_worlds_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.hello_worlds
    ADD CONSTRAINT hello_worlds_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--


PGDMP     '    +                x         
   my_servlet    13.1    13.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24576 
   my_servlet    DATABASE     n   CREATE DATABASE my_servlet WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE my_servlet;
                postgres    false            �            1259    24582    facts    TABLE     e   CREATE TABLE public.facts (
    fact_id integer NOT NULL,
    fact character varying(50) NOT NULL
);
    DROP TABLE public.facts;
       public         heap    postgres    false            �            1259    24580    facts_fact_id_seq    SEQUENCE     �   CREATE SEQUENCE public.facts_fact_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.facts_fact_id_seq;
       public          postgres    false    201            �           0    0    facts_fact_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.facts_fact_id_seq OWNED BY public.facts.fact_id;
          public          postgres    false    200            "           2604    24585    facts fact_id    DEFAULT     n   ALTER TABLE ONLY public.facts ALTER COLUMN fact_id SET DEFAULT nextval('public.facts_fact_id_seq'::regclass);
 <   ALTER TABLE public.facts ALTER COLUMN fact_id DROP DEFAULT;
       public          postgres    false    200    201    201            �          0    24582    facts 
   TABLE DATA           .   COPY public.facts (fact_id, fact) FROM stdin;
    public          postgres    false    201   �       �           0    0    facts_fact_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.facts_fact_id_seq', 12, true);
          public          postgres    false    200            $           2606    24589    facts facts_fact_key 
   CONSTRAINT     O   ALTER TABLE ONLY public.facts
    ADD CONSTRAINT facts_fact_key UNIQUE (fact);
 >   ALTER TABLE ONLY public.facts DROP CONSTRAINT facts_fact_key;
       public            postgres    false    201            &           2606    24587    facts facts_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.facts
    ADD CONSTRAINT facts_pkey PRIMARY KEY (fact_id);
 :   ALTER TABLE ONLY public.facts DROP CONSTRAINT facts_pkey;
       public            postgres    false    201            �     x�-��N�0���S�	*����@��4�\��[��$�J����8��G�5�����:΀)��@OP�rQ�Ny���m�`��;X	�)i!�M}B_Zw�o{PFF~f�Pn�}s��lQ�����Qt[M\|�&J~Ἰ%�4G����a%�J恒�Vs�*{���I���5����Bo5%�ܼ+�����rv�m9����@V�id�{1F�8�Zi\��e�{9���v�q����F�������I�=�c�o����(���W���`�.     
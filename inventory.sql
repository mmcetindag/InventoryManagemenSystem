PGDMP     (                      v         	   inventory    10.1    10.1     �
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �
           1262    16414 	   inventory    DATABASE     �   CREATE DATABASE inventory WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Turkish_Turkey.1254' LC_CTYPE = 'Turkish_Turkey.1254';
    DROP DATABASE inventory;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �
           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �
           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    16421    goods    TABLE     :   CREATE TABLE goods (
    type text,
    amount integer
);
    DROP TABLE public.goods;
       public         postgres    false    3            �            1259    16429    reports    TABLE     ;   CREATE TABLE reports (
    goodname text,
    info text
);
    DROP TABLE public.reports;
       public         postgres    false    3            �            1259    16415    users    TABLE     e   CREATE TABLE users (
    id integer NOT NULL,
    name text,
    password text,
    usertype text
);
    DROP TABLE public.users;
       public         postgres    false    3            �
          0    16421    goods 
   TABLE DATA               &   COPY goods (type, amount) FROM stdin;
    public       postgres    false    197   ;       �
          0    16429    reports 
   TABLE DATA               *   COPY reports (goodname, info) FROM stdin;
    public       postgres    false    198   n       �
          0    16415    users 
   TABLE DATA               6   COPY users (id, name, password, usertype) FROM stdin;
    public       postgres    false    196   �       x
           2606    16425    users users_pkey 
   CONSTRAINT     G   ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public         postgres    false    196            �
   #   x�IL�I�42�
H�K���44500������ i�o      �
     x�m�1n�0E��<@�;d�֡cZ�m5�h��ܾ��:I?��?���߮p�$���7����NIF�Q��3�>ûA�IM�W��N�D���d�C�+үC�d7�	��	Eж�a�=��m�'AI1f��?�ʅ<k�ؗ!�ɠ���U��O\2����|(�u�B�,Օ��%��)|�*:e+U}N�T�7P��\L��R9PF�h�&����5%�D2�Uh�J�Y>��9��=t�rd��爆��o���e� ��	F�/���pC�������i7O_�4M?w��Y      �
   I   x�3�tI��I�4426�tL����2��H��̃����W��rs���$�A��&�d��)x�&�p��qqq ��<     
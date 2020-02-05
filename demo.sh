#!/bin/bash

url_base=http://localhost:8080/reservation

get_available_url=/available
get_available_date_param=date
get_available_intervalBeginning_param=intervalBeginning
get_available_intervalEnding_param=intervalEnding

get_details_url=/details
post_url=/new-reservation

screening_id_1=0
screening_id_2=1

date_param=2020-02-14
interval_beginning_param=10:00
interval_ending_param=21:00:00

post_singe_seat() {
  curl -X POST \
    -H "Content-Type: application/json" \
    ${url_base}${post_url} \
    -d "{
      \"screeningId\" : $1,
      \"user\" : {
          \"name\" : \"Adam\",
          \"surname\" : \"Małysz\"
      },
      \"seats\" : [
          {
              \"rowNumber\" : $2,
              \"numberInRow\" : $3
          }
      ],
      \"tickets\" : [
          {
          \"numberOfTickets\" : 1,
          \"type\" : \"ADULT\"
          }
      ]
    }" \
    -o post_responce_body -s

  cat post_responce_body
  rm post_responce_body

}

post_double_seat() {
  curl -X POST \
    -H "Content-Type: application/json" \
    ${url_base}${post_url} \
    -d "{
      \"screeningId\" : $1,
      \"user\" : {
          \"name\" : \"Adam\",
          \"surname\" : \"Małysz\"
      },
      \"seats\" : [
          {
              \"rowNumber\" : $2,
              \"numberInRow\" : $3
          },
          {
              \"rowNumber\" : $2,
              \"numberInRow\" : $4
          }
      ],
      \"tickets\" : [
          {
          \"numberOfTickets\" : 1,
          \"type\" : \"ADULT\"
          },
          {
          \"numberOfTickets\" : 1,
          \"type\" : \"CHILD\"
          }
      ]
    }" \
    -o post_responce_body -s

  cat post_responce_body
  rm post_responce_body

}

#propositions
curl -X GET \
 ${url_base}${get_available_url} -G \
 -d ${get_available_date_param}=${date_param} \
 -d ${get_available_intervalBeginning_param}=${interval_beginning_param} \
 -d ${get_available_intervalEnding_param}=${interval_ending_param} \
 -o get_available_body -s


echo -e "USER WOULD LIKE TO SEE THE MOVIE \
ON ${date_param} \
BETWEEN ${interval_beginning_param} \
AND ${interval_ending_param}:"
cat get_available_body
rm get_available_body


# screening 1.
curl -X GET \
 ${url_base}${get_details_url}/${screening_id_1} \
 -o screening_details_body -s

echo -e "\n\nUSER SELECTS SCREENING NUMBER ${screening_id_1}:"
cat screening_details_body
rm screening_details_body

user1_seat_row=2
user1_seat1_number_in_row=1
echo -e "\n\nUSER 1. SELECTS SEAT \
IN ROW ${user1_seat_row} \
NUMBER ${user1_seat1_number_in_row}:"

post_singe_seat ${screening_id_1} ${user1_seat_row} ${user1_seat1_number_in_row}
echo -e "\nAND GET CONFIRMATION"


user2_seat_row=2
user2_seat1_number_in_row=3
echo -e "\n\nUSER 2. SELECTS SEATS \
IN ROW ${user2_seat_row} \
NUMBER ${user2_seat1_number_in_row}:"

post_singe_seat ${screening_id_1} ${user2_seat_row} ${user2_seat1_number_in_row}
echo -e "\nAND GET GET EXCEPTION - SINGLE SEAT BETWEEN TWO RESERVED SEATS"


user3_seats_row=2
user3_seat1_number_in_row=3
user3_seat2_number_in_row=2
echo -e "\n\nUSER 3. SELECTS SEATS \
IN ROW ${user3_seats_row} \
NUMBER ${user3_seat1_number_in_row} AND ${user3_seat2_number_in_row}:"

post_double_seat ${screening_id_1} ${user3_seats_row} ${user3_seat1_number_in_row} ${user3_seat2_number_in_row}
echo -e "\nAND GET CONFIRMATION"


user4_seat_row=2
user4_seat1_number_in_row=3
echo -e "\n\nUSER 4. SELECTS SEATS \
IN ROW ${user4_seat_row} \
NUMBER ${user4_seat1_number_in_row}:"

post_singe_seat ${screening_id_1} ${user4_seat_row} ${user4_seat1_number_in_row}
echo -e "\nAND GET GET EXCEPTION - SEAT ALREADY RESERVED"


user5_seat_row=2
user5_seat1_number_in_row=30
echo -e "\n\nUSER 5. SELECTS SEATS \
IN ROW ${user5_seat_row} \
NUMBER ${user5_seat1_number_in_row}:"

post_singe_seat ${screening_id_1} ${user5_seat_row} ${user5_seat1_number_in_row}
echo -e "\nAND GET GET EXCEPTION - SCEERNING ROOM DOESNT CONTAIN SUCH SEAT"


# screening 2.

curl -X GET \
 ${url_base}${get_details_url}/${screening_id_2} \
 -o screening_details_body -s

echo -e "\n\nDIFFERENT USER SELECTS SCREENING NUMBER ${screening_id_2}:"
cat screening_details_body
rm screening_details_body


user6_seat_row=2
user6_seat1_number_in_row=1
echo -e "\n\nUSER 6. SELECTS SEAT \
IN ROW ${user6_seat_row} \
NUMBER ${user6_seat1_number_in_row}:"

post_singe_seat ${screening_id_2} ${user6_seat_row} ${user6_seat1_number_in_row}
echo -e "\nAND GET CONFIRMATION (RESERVATION ON DIFFERENT SCREENING)"

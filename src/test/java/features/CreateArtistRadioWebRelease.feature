Feature: Validation of create Artist Station

  Background:
    Given I have the cookie for the following user for web release
      | username | password |
      | sun@s.in | Saavn123 |

  Scenario Outline: Verify user is able to play artist radio
    Given I have the endpoint for "CreateArtistStation" for web release
    When I make the GET request with query as "<query>" and name as "<name>" and value of k as "<k>"
    Then I validate the response with status code 200 for the artist "<query>"
    Examples:
      | query                         | name                          | k  |
      | A-Kay                         | A-Kay                         | 10 |
      | A.R. Rahman                   | A.R. Rahman                   | 10 |
      | Aakanksha Sharma              | Aakanksha Sharma              | 10 |
      | Aamir Khan                    | Aamir Khan                    | 10 |
      | Aastha Gill                   | Aastha Gill                   | 10 |
      | Abhijeet Bhattacharya         | Abhijeet Bhattacharya         | 10 |
      | Adarsh Shinde                 | Adarsh Shinde                 | 10 |
      | Adnan Sami                    | Adnan Sami                    | 10 |
      | Afsana Khan                   | Afsana Khan                   | 10 |
      | Agam Kumar Nigam              | Agam Kumar Nigam              | 10 |
      | Ajay Devgn                    | Ajay Devgn                    | 10 |
      | Ajay Gogavale                 | Ajay Gogavale                 | 10 |
      | Ajay Hooda                    | Ajay Hooda                    | 10 |
      | Ajay-Atul                     | Ajay-Atul                     | 10 |
      | Ajith Kumar                   | Ajith Kumar                   | 10 |
      | Akhil                         | Akhil                         | 10 |
      | Akon                          | Akon                          | 10 |
      | Akriti Kakar                  | Akriti Kakar                  | 10 |
      | Akshara Singh                 | Akshara Singh                 | 10 |
      | Akshay Kumar                  | Akshay Kumar                  | 10 |
      | Akull                         | Akull                         | 10 |
      | Alan Walker                   | Alan Walker                   | 10 |
      | Alka Chandrakar               | Alka Chandrakar               | 10 |
      | Alka Yagnik                   | Alka Yagnik                   | 10 |
      | All.Ok                        | All.Ok                        | 10 |
      | Allu Arjun                    | Allu Arjun                    | 10 |
      | Altaaf Sayyed                 | Altaaf Sayyed                 | 10 |
      | Altaf Raja                    | Altaf Raja                    | 10 |
      | Amaal Mallik                  | Amaal Mallik                  | 10 |
      | Amar Singh Chamkila           | Amar Singh Chamkila           | 10 |
      | Ambareesh                     | Ambareesh                     | 10 |
      | Amit Kumar                    | Amit Kumar                    | 10 |
      | Amit Saini Rohtakiya          | Amit Saini Rohtakiya          | 10 |
      | Amit Trivedi                  | Amit Trivedi                  | 10 |
      | Amitabh Bachchan              | Amitabh Bachchan              | 10 |
      | Ammy Virk                     | Ammy Virk                     | 10 |
      | Amrinder Gill                 | Amrinder Gill                 | 10 |
      | Amrit Maan                    | Amrit Maan                    | 10 |
      | Amrita Virk                   | Amrita Virk                   | 10 |
      | Anand Shinde                  | Anand Shinde                  | 10 |
      | Anand-Milind                  | Anand-Milind                  | 10 |
      | Ananya Bhat                   | Ananya Bhat                   | 10 |
      | Anil Kapoor                   | Anil Kapoor                   | 10 |
      | Anirudh Ravichander           | Anirudh Ravichander           | 10 |
      | Anjana Sowmya                 | Anjana Sowmya                 | 10 |
      | Ankit Tiwari                  | Ankit Tiwari                  | 10 |
      | Ankush Raja                   | Ankush Raja                   | 10 |
      | Anmol Gagan Maan              | Anmol Gagan Maan              | 10 |
      | Annamayya Keerthana           | Annamayya Keerthana           | 10 |
      | Anne-Marie                    | Anne-Marie                    | 10 |
      | Antara Mitra                  | Antara Mitra                  | 10 |
      | Antra Singh Priyanka          | Antra Singh Priyanka          | 10 |
      | Anu Malik                     | Anu Malik                     | 10 |
      | Anup Jalota                   | Anup Jalota                   | 10 |
      | Anupam Roy                    | Anupam Roy                    | 10 |
      | Anuradha Paudwal              | Anuradha Paudwal              | 10 |
      | Anurag Kulkarni               | Anurag Kulkarni               | 10 |
      | Ariana Grande                 | Ariana Grande                 | 10 |
      | Arijit Singh                  | Arijit Singh                  | 10 |
      | Arjun Janya                   | Arjun Janya                   | 10 |
      | Arjun Kanungo                 | Arjun Kanungo                 | 10 |
      | Armaan Bedil                  | Armaan Bedil                  | 10 |
      | Armaan Malik                  | Armaan Malik                  | 10 |
      | Aseema Panda                  | Aseema Panda                  | 10 |
      | Asees Kaur                    | Asees Kaur                    | 10 |
      | Ash King                      | Ash King                      | 10 |
      | Asha Bhosle                   | Asha Bhosle                   | 10 |
      | Ashok Thakor                  | Ashok Thakor                  | 10 |
      | Atif Aslam                    | Atif Aslam                    | 10 |
      | Attaullah Khan Esakhelvi      | Attaullah Khan Esakhelvi      | 10 |
      | Avadhoot Gupte                | Avadhoot Gupte                | 10 |
      | Avicii                        | Avicii                        | 10 |
      | Ayushmann Khurrana            | Ayushmann Khurrana            | 10 |
      | B Praak                       | B Praak                       | 10 |
      | BTS                           | BTS                           | 10 |
      | Babbu Maan                    | Babbu Maan                    | 10 |
      | Babul Supriyo                 | Babul Supriyo                 | 10 |
      | Badshah                       | Badshah                       | 10 |
      | Balkar Ankhila                | Balkar Ankhila                | 10 |
      | Bansidhar Chaudhary           | Bansidhar Chaudhary           | 10 |
      | Bappi Lahiri                  | Bappi Lahiri                  | 10 |
      | Bebe Rexha                    | Bebe Rexha                    | 10 |
      | Bela Shende                   | Bela Shende                   | 10 |
      | Bhikari Bal                   | Bhikari Bal                   | 10 |
      | Bilal Saeed                   | Bilal Saeed                   | 10 |
      | Billie Eilish                 | Billie Eilish                 | 10 |
      | Bohemia                       | Bohemia                       | 10 |
      | C. Ashwath                    | C. Ashwath                    | 10 |
      | Camila Cabello                | Camila Cabello                | 10 |
      | Chakri                        | Chakri                        | 10 |
      | Chandan Shetty                | Chandan Shetty                | 10 |
      | Charlie Puth                  | Charlie Puth                  | 10 |
      | Chinmayi Sripada              | Chinmayi Sripada              | 10 |
      | Chiranjeevi                   | Chiranjeevi                   | 10 |
      | Coldplay                      | Coldplay                      | 10 |
      | D. Imman                      | D. Imman                      | 10 |
      | DIVINE                        | DIVINE                        | 10 |
      | Dada Kondke                   | Dada Kondke                   | 10 |
      | Daler Mehndi                  | Daler Mehndi                  | 10 |
      | Darshan Raval                 | Darshan Raval                 | 10 |
      | David Guetta                  | David Guetta                  | 10 |
      | Deep Jandu                    | Deep Jandu                    | 10 |
      | Deeplina Deka                 | Deeplina Deka                 | 10 |
      | Deva                          | Deva                          | 10 |
      | Devi Sri Prasad               | Devi Sri Prasad               | 10 |
      | Dhanush                       | Dhanush                       | 10 |
      | Dharampreet                   | Dharampreet                   | 10 |
      | Dhvani Bhanushali             | Dhvani Bhanushali             | 10 |
      | Diler Kharkiya                | Diler Kharkiya                | 10 |
      | Diljit Dosanjh                | Diljit Dosanjh                | 10 |
      | Dilpreet Dhillon              | Dilpreet Dhillon              | 10 |
      | Dinesh Lal Yadav              | Dinesh Lal Yadav              | 10 |
      | Dino James                    | Dino James                    | 10 |
      | Diptirekha Padhi              | Diptirekha Padhi              | 10 |
      | Dj Snake                      | Dj Snake                      | 10 |
      | Dr. Rajkumar                  | Dr. Rajkumar                  | 10 |
      | Drake                         | Drake                         | 10 |
      | Dua Lipa                      | Dua Lipa                      | 10 |
      | Dukalu Yadav                  | Dukalu Yadav                  | 10 |
      | Ed Sheeran                    | Ed Sheeran                    | 10 |
      | Eminem                        | Eminem                        | 10 |
      | Emiway Bantai                 | Emiway Bantai                 | 10 |
      | Emon Khan                     | Emon Khan                     | 10 |
      | Emraan Hashmi                 | Emraan Hashmi                 | 10 |
      | Enrique Iglesias              | Enrique Iglesias              | 10 |
      | Falguni Pathak                | Falguni Pathak                | 10 |
      | Fazilpuria                    | Fazilpuria                    | 10 |
      | Fossils (Band)                | Fossils (Band)                | 10 |
      | Fotty Seven                   | Fotty Seven                   | 10 |
      | G.V. Prakash Kumar            | G.V. Prakash Kumar            | 10 |
      | Gajendra Verma                | Gajendra Verma                | 10 |
      | Gaman Santhal                 | Gaman Santhal                 | 10 |
      | Garry Sandhu                  | Garry Sandhu                  | 10 |
      | Geeta Rabari                  | Geeta Rabari                  | 10 |
      | Geeta Zaildar                 | Geeta Zaildar                 | 10 |
      | Geetha Madhuri                | Geetha Madhuri                | 10 |
      | Ghantasala                    | Ghantasala                    | 10 |
      | Gippy Grewal                  | Gippy Grewal                  | 10 |
      | Golden Star Ganesh            | Golden Star Ganesh            | 10 |
      | Gorelal Barman                | Gorelal Barman                | 10 |
      | Govinda                       | Govinda                       | 10 |
      | Gulzaar Chhaniwala            | Gulzaar Chhaniwala            | 10 |
      | Gunjan Singh                  | Gunjan Singh                  | 10 |
      | Gurdas Maan                   | Gurdas Maan                   | 10 |
      | Guri                          | Guri                          | 10 |
      | Gurjazz                       | Gurjazz                       | 10 |
      | Gurlej Akhtar                 | Gurlej Akhtar                 | 10 |
      | Gurnam Bhullar                | Gurnam Bhullar                | 10 |
      | Guru Randhawa                 | Guru Randhawa                 | 10 |
      | Gurukiran                     | Gurukiran                     | 10 |
      | Hamsalekha                    | Hamsalekha                    | 10 |
      | Hansraj Raghuwanshi           | Hansraj Raghuwanshi           | 10 |
      | Hardy Sandhu                  | Hardy Sandhu                  | 10 |
      | Haricharan                    | Haricharan                    | 10 |
      | Hariharan                     | Hariharan                     | 10 |
      | Harini                        | Harini                        | 10 |
      | Harjit Harman                 | Harjit Harman                 | 10 |
      | Harris Jayaraj                | Harris Jayaraj                | 10 |
      | Harshdeep Kaur                | Harshdeep Kaur                | 10 |
      | Hemant Chauhan                | Hemant Chauhan                | 10 |
      | Himesh Reshammiya             | Himesh Reshammiya             | 10 |
      | Himmat Sandhu                 | Himmat Sandhu                 | 10 |
      | Hiphop Tamizha                | Hiphop Tamizha                | 10 |
      | Hrithik Roshan                | Hrithik Roshan                | 10 |
      | Humane Sagar                  | Humane Sagar                  | 10 |
      | Ikka                          | Ikka                          | 10 |
      | Ilaiyaraaja                   | Ilaiyaraaja                   | 10 |
      | Imagine Dragons               | Imagine Dragons               | 10 |
      | Imran Khan                    | Imran Khan                    | 10 |
      | Inder Chahal                  | Inder Chahal                  | 10 |
      | Indu Sonali                   | Indu Sonali                   | 10 |
      | Ira Mohanty                   | Ira Mohanty                   | 10 |
      | Jaani                         | Jaani                         | 10 |
      | Jagapati Babu                 | Jagapati Babu                 | 10 |
      | Jagjit Singh                  | Jagjit Singh                  | 10 |
      | Jasmine Sandlas               | Jasmine Sandlas               | 10 |
      | Jaspinder Narula              | Jaspinder Narula              | 10 |
      | Jass Bajwa                    | Jass Bajwa                    | 10 |
      | Jass Manak                    | Jass Manak                    | 10 |
      | Jassie Gill                   | Jassie Gill                   | 10 |
      | Jatin-Lalit                   | Jatin-Lalit                   | 10 |
      | Javed Ali                     | Javed Ali                     | 10 |
      | Jaya Kishori Ji               | Jaya Kishori Ji               | 10 |
      | Jazzy B                       | Jazzy B                       | 10 |
      | Jeet Gannguli                 | Jeet Gannguli                 | 10 |
      | Jignesh Barot                 | Jignesh Barot                 | 10 |
      | Jignesh Kaviraj               | Jignesh Kaviraj               | 10 |
      | Jordan Sandhu                 | Jordan Sandhu                 | 10 |
      | Jr. NTR                       | Jr. NTR                       | 10 |
      | Jubin Nautiyal                | Jubin Nautiyal                | 10 |
      | Jugraj Sandhu                 | Jugraj Sandhu                 | 10 |
      | Justin Bieber                 | Justin Bieber                 | 10 |
      | Jyotica Tangri                | Jyotica Tangri                | 10 |
      | K. S. Chithra                 | K. S. Chithra                 | 10 |
      | K.J. Yesudas                  | K.J. Yesudas                  | 10 |
      | KK                            | KK                            | 10 |
      | KS Harisankar                 | KS Harisankar                 | 10 |
      | Kaala Bhairava                | Kaala Bhairava                | 10 |
      | Kailash Kher                  | Kailash Kher                  | 10 |
      | Kajal Maheriya                | Kajal Maheriya                | 10 |
      | Kamal Haasan                  | Kamal Haasan                  | 10 |
      | Kamal Khaira                  | Kamal Khaira                  | 10 |
      | Kambi Rajpuria                | Kambi Rajpuria                | 10 |
      | Kamlesh Barot                 | Kamlesh Barot                 | 10 |
      | Kanwar Grewal                 | Kanwar Grewal                 | 10 |
      | Karan Aujla                   | Karan Aujla                   | 10 |
      | Karan Randhawa                | Karan Randhawa                | 10 |
      | Karthik                       | Karthik                       | 10 |
      | Kavita Krishnamurthy          | Kavita Krishnamurthy          | 10 |
      | Khasa Aala Chahar             | Khasa Aala Chahar             | 10 |
      | Khesari Lal Yadav             | Khesari Lal Yadav             | 10 |
      | Khushboo Uttam                | Khushboo Uttam                | 10 |
      | Kinjal Dave                   | Kinjal Dave                   | 10 |
      | Kirtidan Gadhvi               | Kirtidan Gadhvi               | 10 |
      | Kishore Kumar                 | Kishore Kumar                 | 10 |
      | Korala Maan                   | Korala Maan                   | 10 |
      | Koti                          | Koti                          | 10 |
      | Kousalya                      | Kousalya                      | 10 |
      | Kulbir Jhinjer                | Kulbir Jhinjer                | 10 |
      | Kuldeep Manak                 | Kuldeep Manak                 | 10 |
      | Kulwinder Billa               | Kulwinder Billa               | 10 |
      | Kumar Bapi                    | Kumar Bapi                    | 10 |
      | Kumar Sanu                    | Kumar Sanu                    | 10 |
      | L. R. Eswari                  | L. R. Eswari                  | 10 |
      | Labh Heera                    | Labh Heera                    | 10 |
      | Lakhbir Singh Lakha           | Lakhbir Singh Lakha           | 10 |
      | Lata Mangeshkar               | Lata Mangeshkar               | 10 |
      | Laxmikant - Pyarelal          | Laxmikant - Pyarelal          | 10 |
      | Linkin Park                   | Linkin Park                   | 10 |
      | Lipsika                       | Lipsika                       | 10 |
      | Lucky Ali                     | Lucky Ali                     | 10 |
      | M. M. Keeravani               | M. M. Keeravani               | 10 |
      | M. M. Manasi                  | M. M. Manasi                  | 10 |
      | M.G. Sreekumar                | M.G. Sreekumar                | 10 |
      | MGR                           | MGR                           | 10 |
      | Madan Mohan                   | Madan Mohan                   | 10 |
      | Madhu Priya                   | Madhu Priya                   | 10 |
      | Madhuri Dixit                 | Madhuri Dixit                 | 10 |
      | Mahendra Kapoor               | Mahendra Kapoor               | 10 |
      | Mahesh Babu                   | Mahesh Babu                   | 10 |
      | Majrooh Sultanpuri            | Majrooh Sultanpuri            | 10 |
      | Malaysia Vasudevan            | Malaysia Vasudevan            | 10 |
      | Mamta Chandrakar              | Mamta Chandrakar              | 10 |
      | Manan Bhardwaj                | Manan Bhardwaj                | 10 |
      | Manhar Udhas                  | Manhar Udhas                  | 10 |
      | Mani Sharma                   | Mani Sharma                   | 10 |
      | Maninder Buttar               | Maninder Buttar               | 10 |
      | Mankirt Aulakh                | Mankirt Aulakh                | 10 |
      | Manna Dey                     | Manna Dey                     | 10 |
      | Mano                          | Mano                          | 10 |
      | Mantu Chhuria                 | Mantu Chhuria                 | 10 |
      | Maroon 5                      | Maroon 5                      | 10 |
      | Marshmello                    | Marshmello                    | 10 |
      | Martin Garrix                 | Martin Garrix                 | 10 |
      | Masoom Sharma                 | Masoom Sharma                 | 10 |
      | Mickey J Meyer                | Mickey J Meyer                | 10 |
      | Mika Singh                    | Mika Singh                    | 10 |
      | Millind Gaba                  | Millind Gaba                  | 10 |
      | Miss Pooja                    | Miss Pooja                    | 10 |
      | Mita Chatterjee               | Mita Chatterjee               | 10 |
      | Mithoon                       | Mithoon                       | 10 |
      | Mithun Chakraborty            | Mithun Chakraborty            | 10 |
      | Mohammed Aziz                 | Mohammed Aziz                 | 10 |
      | Mohammed Irfan                | Mohammed Irfan                | 10 |
      | Mohammed Rafi                 | Mohammed Rafi                 | 10 |
      | Mohit Chauhan                 | Mohit Chauhan                 | 10 |
      | Mohit Sharma                  | Mohit Sharma                  | 10 |
      | Mona Sen                      | Mona Sen                      | 10 |
      | Monali Thakur                 | Monali Thakur                 | 10 |
      | Mukesh                        | Mukesh                        | 10 |
      | N.C. Karunya                  | N.C. Karunya                  | 10 |
      | Nachiketa                     | Nachiketa                     | 10 |
      | Nadeem-Shravan                | Nadeem-Shravan                | 10 |
      | Nagarjuna                     | Nagarjuna                     | 10 |
      | Namita Agrawal                | Namita Agrawal                | 10 |
      | Nandamuri Balakrishna         | Nandamuri Balakrishna         | 10 |
      | Nanditha                      | Nanditha                      | 10 |
      | Nani                          | Nani                          | 10 |
      | Navjeet                       | Navjeet                       | 10 |
      | Neel Akash                    | Neel Akash                    | 10 |
      | Neeti Mohan                   | Neeti Mohan                   | 10 |
      | Neffex                        | Neffex                        | 10 |
      | Neha Kakkar                   | Neha Kakkar                   | 10 |
      | Nibedita                      | Nibedita                      | 10 |
      | Nikhita Gandhi                | Nikhita Gandhi                | 10 |
      | Nimrat Khaira                 | Nimrat Khaira                 | 10 |
      | Ninja                         | Ninja                         | 10 |
      | Nirvair Pannu                 | Nirvair Pannu                 | 10 |
      | Nisha Dubey                   | Nisha Dubey                   | 10 |
      | Nitin Mukesh                  | Nitin Mukesh                  | 10 |
      | Nucleya                       | Nucleya                       | 10 |
      | Nusrat Fateh Ali Khan         | Nusrat Fateh Ali Khan         | 10 |
      | One Direction                 | One Direction                 | 10 |
      | P. Susheela                   | P. Susheela                   | 10 |
      | P. Unnikrishnan               | P. Unnikrishnan               | 10 |
      | Palak Muchhal                 | Palak Muchhal                 | 10 |
      | Pankaj Udhas                  | Pankaj Udhas                  | 10 |
      | Papon                         | Papon                         | 10 |
      | Parampara Thakur              | Parampara Thakur              | 10 |
      | Parmish Verma                 | Parmish Verma                 | 10 |
      | Parveen Bharta                | Parveen Bharta                | 10 |
      | Pawan Kalyan                  | Pawan Kalyan                  | 10 |
      | Pawan Singh                   | Pawan Singh                   | 10 |
      | Payal Dev                     | Payal Dev                     | 10 |
      | Pitbull                       | Pitbull                       | 10 |
      | Poornima                      | Poornima                      | 10 |
      | Post Malone                   | Post Malone                   | 10 |
      | Prabh Gill                    | Prabh Gill                    | 10 |
      | Prabhas                       | Prabhas                       | 10 |
      | Prakash Mali                  | Prakash Mali                  | 10 |
      | Prakriti Kakar                | Prakriti Kakar                | 10 |
      | Prateek Kuhad                 | Prateek Kuhad                 | 10 |
      | Prem Anand                    | Prem Anand                    | 10 |
      | Prem Dhillon                  | Prem Dhillon                  | 10 |
      | Pritam                        | Pritam                        | 10 |
      | Priyanka Singh                | Priyanka Singh                | 10 |
      | Puneeth Rajkumar              | Puneeth Rajkumar              | 10 |
      | R Nait                        | R Nait                        | 10 |
      | R. Narayana Murthy            | R. Narayana Murthy            | 10 |
      | R.D. Burman                   | R.D. Burman                   | 10 |
      | R.P. Patnaik                  | R.P. Patnaik                  | 10 |
      | Rabindranath Tagore           | Rabindranath Tagore           | 10 |
      | Raftaar                       | Raftaar                       | 10 |
      | Raghu Dixit                   | Raghu Dixit                   | 10 |
      | Rahat Fateh Ali Khan          | Rahat Fateh Ali Khan          | 10 |
      | Rahul Jain                    | Rahul Jain                    | 10 |
      | Rahul Sipligunj               | Rahul Sipligunj               | 10 |
      | Raj Barman                    | Raj Barman                    | 10 |
      | Raj Brar                      | Raj Brar                      | 10 |
      | Raj Mawer                     | Raj Mawer                     | 10 |
      | Raj-Koti                      | Raj-Koti                      | 10 |
      | Rajan-Nagendra                | Rajan-Nagendra                | 10 |
      | Rajesh Khanna                 | Rajesh Khanna                 | 10 |
      | Rajesh Krishnan               | Rajesh Krishnan               | 10 |
      | Rajinikanth                   | Rajinikanth                   | 10 |
      | Raju Punjabi                  | Raju Punjabi                  | 10 |
      | Rajvir Jawanda                | Rajvir Jawanda                | 10 |
      | Rakesh Barot                  | Rakesh Barot                  | 10 |
      | Rakesh Mishra                 | Rakesh Mishra                 | 10 |
      | Ram Charan                    | Ram Charan                    | 10 |
      | Ramana Gogula                 | Ramana Gogula                 | 10 |
      | Ramya Behara                  | Ramya Behara                  | 10 |
      | Ranbir Kapoor                 | Ranbir Kapoor                 | 10 |
      | Rani Rangili                  | Rani Rangili                  | 10 |
      | Ranina Reddy                  | Ranina Reddy                  | 10 |
      | Ranjit Bawa                   | Ranjit Bawa                   | 10 |
      | Ravi Teja                     | Ravi Teja                     | 10 |
      | Ravinder Grewal               | Ravinder Grewal               | 10 |
      | Ravindra Jain                 | Ravindra Jain                 | 10 |
      | Renuka Panwar                 | Renuka Panwar                 | 10 |
      | Revanth                       | Revanth                       | 10 |
      | Richa Sharma                  | Richa Sharma                  | 10 |
      | Rishi Kapoor                  | Rishi Kapoor                  | 10 |
      | Ritesh Pandey                 | Ritesh Pandey                 | 10 |
      | Ritu Pathak                   | Ritu Pathak                   | 10 |
      | Ritviz                        | Ritviz                        | 10 |
      | Rocky-Shiv                    | Rocky-Shiv                    | 10 |
      | Ruchika Jangid                | Ruchika Jangid                | 10 |
      | Rupam Islam                   | Rupam Islam                   | 10 |
      | S. Janaki                     | S. Janaki                     | 10 |
      | S. P. Balasubrahmanyam        | S. P. Balasubrahmanyam        | 10 |
      | S.A. Rajkumar                 | S.A. Rajkumar                 | 10 |
      | S.P.B. Charan                 | S.P.B. Charan                 | 10 |
      | S.V. Krishna Reddy            | S.V. Krishna Reddy            | 10 |
      | Sachet Tandon                 | Sachet Tandon                 | 10 |
      | Sachin-Jigar                  | Sachin-Jigar                  | 10 |
      | Sadhana Sargam                | Sadhana Sargam                | 10 |
      | Sadhu Kokila                  | Sadhu Kokila                  | 10 |
      | Sagar                         | Sagar                         | 10 |
      | Sahir Ali Bagga               | Sahir Ali Bagga               | 10 |
      | Sajan Bendre                  | Sajan Bendre                  | 10 |
      | Sajid-Wajid                   | Sajid-Wajid                   | 10 |
      | Sajjan Adeeb                  | Sajjan Adeeb                  | 10 |
      | Salim Merchant                | Salim Merchant                | 10 |
      | Salim-Sulaiman                | Salim-Sulaiman                | 10 |
      | Salma Agha                    | Salma Agha                    | 10 |
      | Salman Khan                   | Salman Khan                   | 10 |
      | Samar Singh                   | Samar Singh                   | 10 |
      | Sanam (Band)                  | Sanam (Band)                  | 10 |
      | Sanam Puri                    | Sanam Puri                    | 10 |
      | Sanjay Dutt                   | Sanjay Dutt                   | 10 |
      | Sanjay Mittal                 | Sanjay Mittal                 | 10 |
      | Sanjith Hegde                 | Sanjith Hegde                 | 10 |
      | Sannidhya Bhuyan              | Sannidhya Bhuyan              | 10 |
      | Santhosh Narayanan            | Santhosh Narayanan            | 10 |
      | Sapna Choudhary               | Sapna Choudhary               | 10 |
      | Satinder Sartaaj              | Satinder Sartaaj              | 10 |
      | Satyajeet Jena                | Satyajeet Jena                | 10 |
      | Satyavathi Mangli             | Satyavathi Mangli             | 10 |
      | Seema Mishra                  | Seema Mishra                  | 10 |
      | Selena Gomez                  | Selena Gomez                  | 10 |
      | Shaan                         | Shaan                         | 10 |
      | Shabbir Kumar                 | Shabbir Kumar                 | 10 |
      | Shah Rukh Khan                | Shah Rukh Khan                | 10 |
      | Shahid Kapoor                 | Shahid Kapoor                 | 10 |
      | Shankar Mahadevan             | Shankar Mahadevan             | 10 |
      | Shankar Nag                   | Shankar Nag                   | 10 |
      | Shankar-Ehsaan-Loy            | Shankar-Ehsaan-Loy            | 10 |
      | Shankar-Jaikishan             | Shankar-Jaikishan             | 10 |
      | Sharry Mann                   | Sharry Mann                   | 10 |
      | Shawn Mendes                  | Shawn Mendes                  | 10 |
      | Sheera Jasvir                 | Sheera Jasvir                 | 10 |
      | Shekhar Ravjiani              | Shekhar Ravjiani              | 10 |
      | Shiva Rajkumar                | Shiva Rajkumar                | 10 |
      | Shivjot                       | Shivjot                       | 10 |
      | Shrey Singhal                 | Shrey Singhal                 | 10 |
      | Shreya Ghoshal                | Shreya Ghoshal                | 10 |
      | Shweta Mohan                  | Shweta Mohan                  | 10 |
      | Sid Sriram                    | Sid Sriram                    | 10 |
      | Sidhu Moose Wala              | Sidhu Moose Wala              | 10 |
      | Singer Usha                   | Singer Usha                   | 10 |
      | Singga                        | Singga                        | 10 |
      | Singhsta                      | Singhsta                      | 10 |
      | Sippy Gill                    | Sippy Gill                    | 10 |
      | Sirivennela Seetharama Sastry | Sirivennela Seetharama Sastry | 10 |
      | Sivakarthikeyan               | Sivakarthikeyan               | 10 |
      | Sleeping Music                | Sleeping Music                | 10 |
      | Sonu Nigam                    | Sonu Nigam                    | 10 |
      | Srikanth Meka                 | Srikanth Meka                 | 10 |
      | Stebin Ben                    | Stebin Ben                    | 10 |
      | Subhamita                     | Subhamita                     | 10 |
      | Sucha Yaar                    | Sucha Yaar                    | 10 |
      | Sudeep                        | Sudeep                        | 10 |
      | Sudesh Bhosle                 | Sudesh Bhosle                 | 10 |
      | Sujatha Mohan                 | Sujatha Mohan                 | 10 |
      | Sukh-E Muzical Doctorz        | Sukh-E Muzical Doctorz        | 10 |
      | Sukhwinder Singh              | Sukhwinder Singh              | 10 |
      | Sumit Goswami                 | Sumit Goswami                 | 10 |
      | Sunidhi Chauhan               | Sunidhi Chauhan               | 10 |
      | Sunitha Upadrashta            | Sunitha Upadrashta            | 10 |
      | Suresh Wadkar                 | Suresh Wadkar                 | 10 |
      | Suriya                        | Suriya                        | 10 |
      | Surjit Bhullar                | Surjit Bhullar                | 10 |
      | Swapnil Bandodkar             | Swapnil Bandodkar             | 10 |
      | Swarnalatha                   | Swarnalatha                   | 10 |
      | T.M. Soundararajan            | T.M. Soundararajan            | 10 |
      | Tanishk Bagchi                | Tanishk Bagchi                | 10 |
      | Tapu Mishra                   | Tapu Mishra                   | 10 |
      | Tarsem Jassar                 | Tarsem Jassar                 | 10 |
      | Taylor Swift                  | Taylor Swift                  | 10 |
      | Thaman S.                     | Thaman S.                     | 10 |
      | The Chainsmokers              | The Chainsmokers              | 10 |
      | The PropheC                   | The PropheC                   | 10 |
      | The Weeknd                    | The Weeknd                    | 10 |
      | Tony Kakkar                   | Tony Kakkar                   | 10 |
      | Tulsi Kumar                   | Tulsi Kumar                   | 10 |
      | Udit Narayan                  | Udit Narayan                  | 10 |
      | Upendra                       | Upendra                       | 10 |
      | V. Harikrishna                | V. Harikrishna                | 10 |
      | V. Ravichandran               | V. Ravichandran               | 10 |
      | Vaishali Samant               | Vaishali Samant               | 10 |
      | Vandemataram Srinivas         | Vandemataram Srinivas         | 10 |
      | Varun Dhawan                  | Varun Dhawan                  | 10 |
      | Vasuki Vaibhav                | Vasuki Vaibhav                | 10 |
      | Veet Baljit                   | Veet Baljit                   | 10 |
      | Venkatesh                     | Venkatesh                     | 10 |
      | Vijay                         | Vijay                         | 10 |
      | Vijay Antony                  | Vijay Antony                  | 10 |
      | Vijay Prakash                 | Vijay Prakash                 | 10 |
      | Vijay Sethupathi              | Vijay Sethupathi              | 10 |
      | Vijay Suvada                  | Vijay Suvada                  | 10 |
      | Vikram Thakor                 | Vikram Thakor                 | 10 |
      | Vilen                         | Vilen                         | 10 |
      | Vinod Rathod                  | Vinod Rathod                  | 10 |
      | Viruss                        | Viruss                        | 10 |
      | Vishal Dadlani                | Vishal Dadlani                | 10 |
      | Vishal Mishra                 | Vishal Mishra                 | 10 |
      | Vishal-Shekhar                | Vishal-Shekhar                | 10 |
      | Vishnuvardhan                 | Vishnuvardhan                 | 10 |
      | Wiz Khalifa                   | Wiz Khalifa                   | 10 |
      | XXXTENTACION                  | XXXTENTACION                  | 10 |
      | Yash                          | Yash                          | 10 |
      | Yasser Desai                  | Yasser Desai                  | 10 |
      | Yazin Nizar                   | Yazin Nizar                   | 10 |
      | Yo Yo Honey Singh             | Yo Yo Honey Singh             | 10 |
      | Yuvan Shankar Raja            | Yuvan Shankar Raja            | 10 |
      | Zack Knight                   | Zack Knight                   | 10 |
      | Zayn Malik                    | Zayn Malik                    | 10 |
      | Zubeen Garg                   | Zubeen Garg                   | 10 |
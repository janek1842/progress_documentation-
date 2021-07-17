# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'BuyTicketWidget.ui'
#
# Created by: PyQt5 UI code generator 5.15.2
#
# WARNING: Any manual changes made to this file will be lost when pyuic5 is
# run again.  Do not edit this file unless you know what you are doing.


from PyQt5 import QtCore, QtGui, QtWidgets
import TicketAir

class Ui_BUYTICKETPanel(object):
    def setupUi(self, BUYTICKETPanel):
        BUYTICKETPanel.setObjectName("BUYTICKETPanel")
        BUYTICKETPanel.resize(795, 732)
        BUYTICKETPanel.setMinimumSize(QtCore.QSize(500, 700))
        self.verticalLayout = QtWidgets.QVBoxLayout(BUYTICKETPanel)
        self.verticalLayout.setContentsMargins(0, 0, 0, 0)
        self.verticalLayout.setSpacing(0)
        self.verticalLayout.setObjectName("verticalLayout")
        self.top = QtWidgets.QFrame(BUYTICKETPanel)
        self.top.setMaximumSize(QtCore.QSize(16777215, 40))
        self.top.setBaseSize(QtCore.QSize(0, 0))
        self.top.setStyleSheet("background-color: rgb(255, 255, 127);")
        self.top.setFrameShape(QtWidgets.QFrame.StyledPanel)
        self.top.setFrameShadow(QtWidgets.QFrame.Raised)
        self.top.setObjectName("top")
        self.horizontalLayout_2 = QtWidgets.QHBoxLayout(self.top)
        self.horizontalLayout_2.setContentsMargins(0, 0, 0, 0)
        self.horizontalLayout_2.setSpacing(0)
        self.horizontalLayout_2.setObjectName("horizontalLayout_2")
        self.ERRORFrame = QtWidgets.QFrame(self.top)
        self.ERRORFrame.setMaximumSize(QtCore.QSize(450, 35))
        self.ERRORFrame.setStyleSheet("background-color: rgb(170, 255, 127);\n"
                                      "border-radius: 5px;")
        self.ERRORFrame.setFrameShape(QtWidgets.QFrame.StyledPanel)
        self.ERRORFrame.setFrameShadow(QtWidgets.QFrame.Raised)
        self.ERRORFrame.setObjectName("ERRORFrame")
        self.horizontalLayout_3 = QtWidgets.QHBoxLayout(self.ERRORFrame)
        self.horizontalLayout_3.setContentsMargins(6, 6, 6, 6)
        self.horizontalLayout_3.setSpacing(4)
        self.horizontalLayout_3.setObjectName("horizontalLayout_3")
        self.ERRORLabel = QtWidgets.QLabel(self.ERRORFrame)
        font = QtGui.QFont()
        font.setPointSize(12)
        self.ERRORLabel.setFont(font)
        self.ERRORLabel.setLayoutDirection(QtCore.Qt.LeftToRight)
        self.ERRORLabel.setAlignment(QtCore.Qt.AlignCenter)
        self.ERRORLabel.setObjectName("ERRORLabel")
        self.horizontalLayout_3.addWidget(self.ERRORLabel)
        self.ERRORXButton = QtWidgets.QPushButton(self.ERRORFrame)
        self.ERRORXButton.setMaximumSize(QtCore.QSize(15, 15))
        self.ERRORXButton.setStyleSheet("QPushButton {\n"
                                        "    border-raadius: 5px;\n"
                                        "    background-position: centre;\n"
                                        "    border: 2px solid;\n"
                                        "}\n"
                                        "\n"
                                        "QPushButton:hover {\n"
                                        "    background-color: rgb(50, 50, 50);\n"
                                        "    color: rgb(255, 234, 70);\n"
                                        "}\n"
                                        "\n"
                                        "QPushButton:pressed {\n"
                                        "    background-color: rgb(35, 35, 35);\n"
                                        "    color: rgb(255, 234, 70);\n"
                                        "}")
        self.ERRORXButton.setObjectName("ERRORXButton")
        self.horizontalLayout_3.addWidget(self.ERRORXButton)
        self.horizontalLayout_2.addWidget(self.ERRORFrame)
        self.verticalLayout.addWidget(self.top)
        self.content = QtWidgets.QFrame(BUYTICKETPanel)
        self.content.setStyleSheet("background-color: rgb(143, 143, 143);")
        self.content.setFrameShape(QtWidgets.QFrame.StyledPanel)
        self.content.setFrameShadow(QtWidgets.QFrame.Raised)
        self.content.setObjectName("content")
        self.horizontalLayout = QtWidgets.QHBoxLayout(self.content)
        self.horizontalLayout.setObjectName("horizontalLayout")
        self.main = QtWidgets.QFrame(self.content)
        self.main.setMaximumSize(QtCore.QSize(750, 550))
        self.main.setStyleSheet("background-color: rgb(57, 57, 57);\n"
                                "border-radius: 10px;")
        self.main.setFrameShape(QtWidgets.QFrame.StyledPanel)
        self.main.setFrameShadow(QtWidgets.QFrame.Raised)
        self.main.setObjectName("main")
        self.HANDLUGGAGERadioButton = QtWidgets.QRadioButton(self.main)
        self.HANDLUGGAGERadioButton.setGeometry(QtCore.QRect(280, 320, 31, 21))
        self.HANDLUGGAGERadioButton.setStyleSheet("QRadioButton::indicator {\n"
                                                  "    border: 3px solid rgb(100,100,100);\n"
                                                  "    width: 15px;\n"
                                                  "    height: 15px;\n"
                                                  "    border-radius: 10px;\n"
                                                  "    background-color: rgb(135, 135, 135);\n"
                                                  "}\n"
                                                  "\n"
                                                  "QRadioButton::indicator:checked {\n"
                                                  "    border: 3px solid rgb(255,255,0);\n"
                                                  "    background-color: rgb(255, 255, 127);\n"
                                                  "}")
        self.HANDLUGGAGERadioButton.setText("")
        self.HANDLUGGAGERadioButton.setObjectName("HANDLUGGAGERadioButton")
        self.LOGOFrame = QtWidgets.QFrame(self.main)
        self.LOGOFrame.setGeometry(QtCore.QRect(290, 10, 191, 171))
        self.LOGOFrame.setStyleSheet("background-image: url(:/LOGO/img/logo.png);")
        self.LOGOFrame.setFrameShape(QtWidgets.QFrame.StyledPanel)
        self.LOGOFrame.setFrameShadow(QtWidgets.QFrame.Raised)
        self.LOGOFrame.setObjectName("LOGOFrame")
        self.FLIGHTNUMBERLabel = QtWidgets.QLineEdit(self.main)
        self.FLIGHTNUMBERLabel.setGeometry(QtCore.QRect(170, 200, 461, 45))
        font = QtGui.QFont()
        font.setPointSize(10)
        self.FLIGHTNUMBERLabel.setFont(font)
        self.FLIGHTNUMBERLabel.setStyleSheet("QLineEdit {\n"
                                             "    border: 2px solid rgb(45,45,45);\n"
                                             "    border-radius: 5px;    \n"
                                             "    padding: 15 px;\n"
                                             "    background-color: rgb(30,30,30);\n"
                                             "    \n"
                                             "    color: rgb(255, 255, 255);\n"
                                             "}\n"
                                             "\n"
                                             "QLineEdit:hover {\n"
                                             "    border: 2px solid rgb(55,55,55);\n"
                                             "}\n"
                                             "\n"
                                             "QLineEdit:focus {\n"
                                             "    border: 2px solid rgb(255,255,127);\n"
                                             "    color: rgb(200,200,200)\n"
                                             "}")
        self.FLIGHTNUMBERLabel.setText(self.flight)
        if self.flight != '':
            self.FLIGHTNUMBERLabel.setReadOnly(True)
        self.FLIGHTNUMBERLabel.setMaxLength(100)
        self.FLIGHTNUMBERLabel.setObjectName("FLIGHTNUMBERLabel")
        self.NAMELabel = QtWidgets.QLineEdit(self.main)
        self.NAMELabel.setGeometry(QtCore.QRect(170, 260, 221, 45))
        font = QtGui.QFont()
        font.setPointSize(10)
        self.NAMELabel.setFont(font)
        self.NAMELabel.setStyleSheet("QLineEdit {\n"
                                     "    border: 2px solid rgb(45,45,45);\n"
                                     "    border-radius: 5px;    \n"
                                     "    padding: 15 px;\n"
                                     "    background-color: rgb(30,30,30);\n"
                                     "    \n"
                                     "    color: rgb(255, 255, 255);\n"
                                     "}\n"
                                     "\n"
                                     "QLineEdit:hover {\n"
                                     "    border: 2px solid rgb(55,55,55);\n"
                                     "}\n"
                                     "\n"
                                     "QLineEdit:focus {\n"
                                     "    border: 2px solid rgb(255,255,127);\n"
                                     "    color: rgb(200,200,200)\n"
                                     "}")
        self.NAMELabel.setText("")
        self.NAMELabel.setMaxLength(100)
        self.NAMELabel.setObjectName("NAMELabel")
        self.SURNAMELabel = QtWidgets.QLineEdit(self.main)
        self.SURNAMELabel.setGeometry(QtCore.QRect(410, 260, 221, 45))
        font = QtGui.QFont()
        font.setPointSize(10)
        self.SURNAMELabel.setFont(font)
        self.SURNAMELabel.setStyleSheet("QLineEdit {\n"
                                        "    border: 2px solid rgb(45,45,45);\n"
                                        "    border-radius: 5px;    \n"
                                        "    padding: 15 px;\n"
                                        "    background-color: rgb(30,30,30);\n"
                                        "    \n"
                                        "    color: rgb(255, 255, 255);\n"
                                        "}\n"
                                        "\n"
                                        "QLineEdit:hover {\n"
                                        "    border: 2px solid rgb(55,55,55);\n"
                                        "}\n"
                                        "\n"
                                        "QLineEdit:focus {\n"
                                        "    border: 2px solid rgb(255,255,127);\n"
                                        "    color: rgb(200,200,200)\n"
                                        "}")
        self.SURNAMELabel.setText("")
        self.SURNAMELabel.setMaxLength(100)
        self.SURNAMELabel.setObjectName("SURNAMELabel")
        self.LABELCAPACITY = QtWidgets.QLabel(self.main)
        self.LABELCAPACITY.setGeometry(QtCore.QRect(170, 310, 101, 51))
        font = QtGui.QFont()
        font.setPointSize(10)
        self.LABELCAPACITY.setFont(font)
        self.LABELCAPACITY.setStyleSheet("color: rgb(255, 255, 255);")
        self.LABELCAPACITY.setObjectName("LABELCAPACITY")
        self.HANDLUGGAGE = QtWidgets.QLabel(self.main)
        self.HANDLUGGAGE.setGeometry(QtCore.QRect(310, 320, 61, 31))
        font = QtGui.QFont()
        font.setPointSize(6)
        self.HANDLUGGAGE.setFont(font)
        self.HANDLUGGAGE.setStyleSheet("color: rgb(255, 255, 255);")
        self.HANDLUGGAGE.setObjectName("HANDLUGGAGE")
        self.UNDER15KG = QtWidgets.QLabel(self.main)
        self.UNDER15KG.setGeometry(QtCore.QRect(420, 320, 61, 31))
        font = QtGui.QFont()
        font.setPointSize(6)
        self.UNDER15KG.setFont(font)
        self.UNDER15KG.setStyleSheet("color: rgb(255, 255, 255);")
        self.UNDER15KG.setObjectName("UNDER15KG")
        self.OVER15KG = QtWidgets.QLabel(self.main)
        self.OVER15KG.setGeometry(QtCore.QRect(520, 320, 61, 31))
        font = QtGui.QFont()
        font.setPointSize(6)
        self.OVER15KG.setFont(font)
        self.OVER15KG.setStyleSheet("color: rgb(255, 255, 255);")
        self.OVER15KG.setObjectName("OVER15KG")
        self.UNDER15KGRadioButton = QtWidgets.QRadioButton(self.main)
        self.UNDER15KGRadioButton.setGeometry(QtCore.QRect(390, 320, 31, 21))
        self.UNDER15KGRadioButton.setStyleSheet("QRadioButton::indicator {\n"
                                                "    border: 3px solid rgb(100,100,100);\n"
                                                "    width: 15px;\n"
                                                "    height: 15px;\n"
                                                "    border-radius: 10px;\n"
                                                "    background-color: rgb(135, 135, 135);\n"
                                                "}\n"
                                                "\n"
                                                "QRadioButton::indicator:checked {\n"
                                                "    border: 3px solid rgb(255,255,0);\n"
                                                "    background-color: rgb(255, 255, 127);\n"
                                                "}")
        self.UNDER15KGRadioButton.setText("")
        self.UNDER15KGRadioButton.setObjectName("UNDER15KGRadioButton")
        self.OVER15KGRadioButton = QtWidgets.QRadioButton(self.main)
        self.OVER15KGRadioButton.setGeometry(QtCore.QRect(490, 320, 31, 21))
        self.OVER15KGRadioButton.setStyleSheet("QRadioButton::indicator {\n"
                                               "    border: 3px solid rgb(100,100,100);\n"
                                               "    width: 15px;\n"
                                               "    height: 15px;\n"
                                               "    border-radius: 10px;\n"
                                               "    background-color: rgb(135, 135, 135);\n"
                                               "}\n"
                                               "\n"
                                               "QRadioButton::indicator:checked {\n"
                                               "    border: 3px solid rgb(255,255,0);\n"
                                               "    background-color: rgb(255, 255, 127);\n"
                                               "}")
        self.OVER15KGRadioButton.setText("")
        self.OVER15KGRadioButton.setObjectName("OVER15KGRadioButton")
        self.BUYButton = QtWidgets.QPushButton(self.main)
        self.BUYButton.setGeometry(QtCore.QRect(280, 460, 201, 31))
        font = QtGui.QFont()
        font.setPointSize(14)
        font.setBold(True)
        font.setWeight(75)
        self.BUYButton.setFont(font)
        self.BUYButton.setStyleSheet("QPushButton {\n"
                                     "    background-color: rgb(255, 255, 127);\n"
                                     "    border: 2px solid rgb(60,60,60);\n"
                                     "    border-radius: 5px;\n"
                                     "}\n"
                                     "\n"
                                     "QPushButton:hover {\n"
                                     "    background-color: rgb(60, 60, 60);\n"
                                     "    border: 2px solid rgb(70,70,70);\n"
                                     "    border-radius: 5px;\n"
                                     "}\n"
                                     "\n"
                                     "QPushButton:pressed {\n"
                                     "    background-color: rgb(255, 255, 127);\n"
                                     "    border: 2px solid rgb(0,0,0);\n"
                                     "    border-radius: 5px;\n"
                                     "    \n"
                                     "    color: rgb(35, 35, 35);\n"
                                     "}")
        self.BUYButton.setObjectName("BUYButton")
        self.NUMBEROFPASSENGERS = QtWidgets.QLabel(self.main)
        self.NUMBEROFPASSENGERS.setGeometry(QtCore.QRect(170, 350, 171, 31))
        font = QtGui.QFont()
        font.setPointSize(10)
        self.NUMBEROFPASSENGERS.setFont(font)
        self.NUMBEROFPASSENGERS.setStyleSheet("color: rgb(255, 255, 255);")
        self.NUMBEROFPASSENGERS.setObjectName("NUMBEROFPASSENGERS")
        self.NUMBEROFPASSENGERSComboBox = QtWidgets.QComboBox(self.main)
        self.NUMBEROFPASSENGERSComboBox.setGeometry(QtCore.QRect(350, 360, 131, 21))
        self.NUMBEROFPASSENGERSComboBox.setStyleSheet("background-color: rgb(200, 200, 200);\n"
                                                      "border-radius: 10px;")
        self.NUMBEROFPASSENGERSComboBox.setObjectName("NUMBEROFPASSENGERSComboBox")
        self.Line = QtWidgets.QLabel(self.main)
        self.Line.setGeometry(QtCore.QRect(190, 170, 401, 16))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.Line.setFont(font)
        self.Line.setStyleSheet("color: rgb(0, 85, 127);")
        self.Line.setObjectName("Line")
        self.TOTAL = QtWidgets.QLabel(self.main)
        self.TOTAL.setGeometry(QtCore.QRect(490, 390, 51, 41))
        font = QtGui.QFont()
        font.setPointSize(12)
        self.TOTAL.setFont(font)
        self.TOTAL.setStyleSheet("color: rgb(255, 255, 255);")
        self.TOTAL.setObjectName("TOTAL")
        self.TOTALPRICELabel = QtWidgets.QLabel(self.main)
        self.TOTALPRICELabel.setGeometry(QtCore.QRect(550, 400, 70, 21))
        font = QtGui.QFont()
        font.setPointSize(10)
        font.setBold(False)
        font.setWeight(50)
        self.TOTALPRICELabel.setFont(font)
        self.TOTALPRICELabel.setStyleSheet("color: rgb(255, 85, 127);")
        self.TOTALPRICELabel.setObjectName("TOTALPRICELabel")
        self.PASSWORDLabel = QtWidgets.QFrame(self.main)
        self.PASSWORDLabel.setGeometry(QtCore.QRect(660, 450, 750, 439))
        self.PASSWORDLabel.setMaximumSize(QtCore.QSize(750, 550))
        font = QtGui.QFont()
        font.setPointSize(12)
        self.PASSWORDLabel.setFont(font)
        self.PASSWORDLabel.setStyleSheet("background-color: rgb(57, 57, 57);\n"
                                         "border-radius: 10px;")
        self.PASSWORDLabel.setFrameShape(QtWidgets.QFrame.StyledPanel)
        self.PASSWORDLabel.setFrameShadow(QtWidgets.QFrame.Raised)
        self.PASSWORDLabel.setObjectName("PASSWORDLabel")
        self.NUMBEROFPASSENGERSLabel = QtWidgets.QLineEdit(self.PASSWORDLabel)
        self.NUMBEROFPASSENGERSLabel.setGeometry(QtCore.QRect(130, 350, 461, 45))
        font = QtGui.QFont()
        font.setPointSize(10)
        self.NUMBEROFPASSENGERSLabel.setFont(font)
        self.NUMBEROFPASSENGERSLabel.setStyleSheet("QLineEdit {\n"
                                                   "    border: 2px solid rgb(45,45,45);\n"
                                                   "    border-radius: 5px;    \n"
                                                   "    padding: 15 px;\n"
                                                   "    background-color: rgb(30,30,30);\n"
                                                   "    \n"
                                                   "    color: rgb(255, 255, 255);\n"
                                                   "}\n"
                                                   "\n"
                                                   "QLineEdit:hover {\n"
                                                   "    border: 2px solid rgb(55,55,55);\n"
                                                   "}\n"
                                                   "\n"
                                                   "QLineEdit:focus {\n"
                                                   "    border: 2px solid rgb(255,255,127);\n"
                                                   "    color: rgb(200,200,200)\n"
                                                   "}")
        self.NUMBEROFPASSENGERSLabel.setText("")
        self.NUMBEROFPASSENGERSLabel.setMaxLength(100)
        self.NUMBEROFPASSENGERSLabel.setObjectName("NUMBEROFPASSENGERSLabel")
        self.HANGLUGGAGEBox = QtWidgets.QCheckBox(self.PASSWORDLabel)
        self.HANGLUGGAGEBox.setGeometry(QtCore.QRect(280, 300, 21, 21))
        font = QtGui.QFont()
        font.setFamily("Segoe UI")
        font.setPointSize(10)
        self.HANGLUGGAGEBox.setFont(font)
        self.HANGLUGGAGEBox.setStyleSheet("QCheckBox::indicator {\n"
                                          "    border: 3px solid rgb(100,100,100);\n"
                                          "    width: 15px;\n"
                                          "    height: 15px;\n"
                                          "    border-radius: 10px;\n"
                                          "    background-color: rgb(135, 135, 135);\n"
                                          "}\n"
                                          "\n"
                                          "QCheckBox::indicator:checked {\n"
                                          "    border: 3px solid rgb(255,255,0);\n"
                                          "    background-color: rgb(255, 255, 127);\n"
                                          "}")
        self.HANGLUGGAGEBox.setText("")
        self.HANGLUGGAGEBox.setObjectName("HANGLUGGAGEBox")
        self.UNDER15KGBox = QtWidgets.QCheckBox(self.PASSWORDLabel)
        self.UNDER15KGBox.setGeometry(QtCore.QRect(400, 300, 21, 21))
        font = QtGui.QFont()
        font.setFamily("Segoe UI")
        font.setPointSize(10)
        self.UNDER15KGBox.setFont(font)
        self.UNDER15KGBox.setStyleSheet("QCheckBox::indicator {\n"
                                        "    border: 3px solid rgb(100,100,100);\n"
                                        "    width: 15px;\n"
                                        "    height: 15px;\n"
                                        "    border-radius: 10px;\n"
                                        "    background-color: rgb(135, 135, 135);\n"
                                        "}\n"
                                        "\n"
                                        "QCheckBox::indicator:checked {\n"
                                        "    border: 3px solid rgb(255,255,0);\n"
                                        "    background-color: rgb(255, 255, 127);\n"
                                        "}")
        self.UNDER15KGBox.setText("")
        self.UNDER15KGBox.setObjectName("UNDER15KGBox")
        self.OVER15KGBox = QtWidgets.QCheckBox(self.PASSWORDLabel)
        self.OVER15KGBox.setGeometry(QtCore.QRect(500, 300, 21, 21))
        font = QtGui.QFont()
        font.setFamily("Segoe UI")
        font.setPointSize(10)
        self.OVER15KGBox.setFont(font)
        self.OVER15KGBox.setStyleSheet("QCheckBox::indicator {\n"
                                       "    border: 3px solid rgb(100,100,100);\n"
                                       "    width: 15px;\n"
                                       "    height: 15px;\n"
                                       "    border-radius: 10px;\n"
                                       "    background-color: rgb(135, 135, 135);\n"
                                       "}\n"
                                       "\n"
                                       "QCheckBox::indicator:checked {\n"
                                       "    border: 3px solid rgb(255,255,0);\n"
                                       "    background-color: rgb(255, 255, 127);\n"
                                       "}")
        self.OVER15KGBox.setText("")
        self.OVER15KGBox.setObjectName("OVER15KGBox")
        self.LogoFrame = QtWidgets.QFrame(self.PASSWORDLabel)
        self.LogoFrame.setGeometry(QtCore.QRect(260, 0, 191, 171))
        self.LogoFrame.setStyleSheet("background-image: url(:/LOGO/img/logo.png);")
        self.LogoFrame.setFrameShape(QtWidgets.QFrame.StyledPanel)
        self.LogoFrame.setFrameShadow(QtWidgets.QFrame.Raised)
        self.LogoFrame.setObjectName("LogoFrame")
        self.TOTALPRICECURRENCYLabel = QtWidgets.QLabel(self.PASSWORDLabel)
        self.TOTALPRICECURRENCYLabel.setGeometry(QtCore.QRect(580, 410, 70, 21))
        font = QtGui.QFont()
        font.setPointSize(10)
        font.setBold(False)
        font.setWeight(50)
        self.TOTALPRICECURRENCYLabel.setFont(font)
        self.TOTALPRICECURRENCYLabel.setStyleSheet("color: rgb(255, 85, 127);")
        self.TOTALPRICECURRENCYLabel.setObjectName("TOTALPRICECURRENCYLabel")
        self.CURRENCYLabel = QtWidgets.QLabel(self.main)
        self.CURRENCYLabel.setGeometry(QtCore.QRect(620, 400, 20, 20))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(False)
        font.setWeight(50)
        self.CURRENCYLabel.setFont(font)
        self.CURRENCYLabel.setStyleSheet("color: rgb(255, 85, 127);")
        self.CURRENCYLabel.setObjectName("CURRENCYLabel")
        self.horizontalLayout.addWidget(self.main)
        self.verticalLayout.addWidget(self.content)
        self.bottom = QtWidgets.QFrame(BUYTICKETPanel)
        self.bottom.setMaximumSize(QtCore.QSize(16777215, 40))
        self.bottom.setBaseSize(QtCore.QSize(0, 0))
        self.bottom.setStyleSheet("background-color: rgb(255, 255, 127);")
        self.bottom.setFrameShape(QtWidgets.QFrame.StyledPanel)
        self.bottom.setFrameShadow(QtWidgets.QFrame.Raised)
        self.bottom.setObjectName("bottom")
        self.verticalLayout.addWidget(self.bottom)

        self.retranslateUi(BUYTICKETPanel)
        QtCore.QMetaObject.connectSlotsByName(BUYTICKETPanel)

        self.BUYButton.setEnabled(False)
        self.ERRORFrame.hide()
        self.BUYButton.clicked.connect(self.buyTicket)
        self.FLIGHTNUMBERLabel.editingFinished.connect(self.edited)
        self.ERRORXButton.clicked.connect(self.hideError)
        self.NUMBEROFPASSENGERSComboBox.activated.connect(self.updatePrice)

        self.HANDLUGGAGERadioButton.toggled.connect(self.updateLuggagePrice)
        self.HANDLUGGAGERadioButton.toggled.connect(self.updateLuggagePrice)
        self.UNDER15KGRadioButton.toggled.connect(self.updateLuggagePrice)

        self.HANDLUGGAGERadioButton.setEnabled(False)
        self.UNDER15KGRadioButton.setEnabled(False)
        self.OVER15KGRadioButton.setEnabled(False)

        self.NAMELabel.setEnabled(False)
        self.SURNAMELabel.setEnabled(False)

    def retranslateUi(self, BUYTICKETPanel):
        _translate = QtCore.QCoreApplication.translate
        BUYTICKETPanel.setWindowTitle(_translate("BUYTICKETPanel", "BUY TICKET"))
        self.ERRORLabel.setText(_translate("BUYTICKETPanel", "THANK YOU FOR SHOPPING. HAVE A NICE FLIGHT!"))
        self.ERRORXButton.setText(_translate("BUYTICKETPanel", "X"))
        self.FLIGHTNUMBERLabel.setPlaceholderText(_translate("BUYTICKETPanel", "FLIGHT NUMBER"))
        self.NAMELabel.setPlaceholderText(_translate("BUYTICKETPanel", "FROM"))
        self.SURNAMELabel.setPlaceholderText(_translate("BUYTICKETPanel", "TO"))
        self.LABELCAPACITY.setText(_translate("BUYTICKETPanel", "LABEL CAPACITY:"))
        self.HANDLUGGAGE.setText(_translate("BUYTICKETPanel", "HAND LUGGAGE"))
        self.UNDER15KG.setText(_translate("BUYTICKETPanel", "UNDER 15 KG"))
        self.OVER15KG.setText(_translate("BUYTICKETPanel", "OVER 15 KG"))
        self.BUYButton.setText(_translate("BUYTICKETPanel", "BUY"))
        self.NUMBEROFPASSENGERS.setText(_translate("BUYTICKETPanel", "NUMBER OF PASSENGERS:"))
        self.Line.setText(_translate("BUYTICKETPanel",
                                     "____________________________________________________________________________________________"))
        self.TOTAL.setText(_translate("BUYTICKETPanel", "TOTAL:"))
        self.TOTALPRICELabel.setText(_translate("BUYTICKETPanel", "----"))
        self.NUMBEROFPASSENGERSLabel.setPlaceholderText(_translate("BUYTICKETPanel", "NUMBER OF PASSENGERS"))
        self.TOTALPRICECURRENCYLabel.setText(_translate("BUYTICKETPanel", "€"))
        self.CURRENCYLabel.setText(_translate("BUYTICKETPanel", "€"))

    def buyTicket(self):
        db = TicketAir.DataBase()
        luggage = 0
        if self.UNDER15KGRadioButton.isChecked():
            luggage = 1
        if self.OVER15KGRadioButton.isChecked():
            luggage = 2
        flight = db.getFlight(self.FLIGHTNUMBERLabel.text())
        ticket = TicketAir.Ticket(flight, self.price, int(self.NUMBEROFPASSENGERSComboBox.currentText()), luggage)
        db.addTicket(self.nick, ticket)

    def edited(self):
        db = TicketAir.DataBase()
        flight = db.getFlight(self.FLIGHTNUMBERLabel.text())
        if flight != None:
            self.TOTALPRICELabel.setText(str(flight.price))
            self.NAMELabel.setText(str(flight.origin))
            self.SURNAMELabel.setText(str(flight.destination))
            self.BUYButton.setEnabled(True)
            self.updateCombo(flight)
            self.HANDLUGGAGERadioButton.setEnabled(True)
            self.UNDER15KGRadioButton.setEnabled(True)
            self.OVER15KGRadioButton.setEnabled(True)
            self.price = flight.price
            self.HANDLUGGAGERadioButton.setChecked(True)
        else:
            self.TOTALPRICELabel.setText('----')
            self.BUYButton.setEnabled(False)
            self.NUMBEROFPASSENGERSComboBox.clear()
            self.HANDLUGGAGERadioButton.setEnabled(False)
            self.UNDER15KGRadioButton.setEnabled(False)
            self.OVER15KGRadioButton.setEnabled(False)
            self.HANDLUGGAGERadioButton.setChecked(False)
            self.UNDER15KGRadioButton.setChecked(False)
            self.OVER15KGRadioButton.setChecked(False)
            self.NAMELabel.setText('')
            self.SURNAMELabel.setText('')

    def __init__(self, nick, flight = ''):
        self.nick = nick
        self.flight = flight

    def hideError(self):
        self.ERRORLabel.hide()

    def updateCombo(self, flight):
        self.NUMBEROFPASSENGERSComboBox.clear()
        n = min(flight.plane.capacity - flight.sold, 10)
        if n != 0:
            for i in range(1, n+1):
                self.NUMBEROFPASSENGERSComboBox.addItem(str(i))
        else:
            self.ERRORFrame.show()
            self.ERRORLabel.setText('Sorry, this flight is full.')
            self.BUYButton.setEnabled(False)

    def updatePrice(self):
        db = TicketAir.DataBase()
        flight = db.getFlight(self.FLIGHTNUMBERLabel.text())
        self.price = flight.price
        self.updateLuggagePrice()

    #Funkcja wywoływana przy każdym zaznaczeniu jednego z trzech RadioButtonów znajdującego się na tym widgecie

    def updateLuggagePrice(self):
        #ZADANIE 3:
        # Dopisz funkcję tak, żeby rodzaj bagażu miał wpływ na cenę końcową biletu.
        # Uwaga: Bagaż poniżej 15kg powinien zwiększać cenę biletu o 5% a cięższy o 15%
        priceValue = 0
        if self.HANDLUGGAGERadioButton.isChecked():
            self.price * int(self.NUMBEROFPASSENGERSComboBox.currentText())

        if self.UNDER15KGRadioButton.isChecked():
            self.price * int(self.NUMBEROFPASSENGERSComboBox.currentText()) * (1 + 0.05)

        if self.OVER15KGRadioButton.isChecked():
            self.price * int(self.NUMBEROFPASSENGERSComboBox.currentText()) * (1 + 0.15)

import file

if __name__ == "__main__":
    import sys

    app = QtWidgets.QApplication(sys.argv)
    BUYTICKETPanel = QtWidgets.QWidget()
    ui = Ui_BUYTICKETPanel('piotr')
    ui.setupUi(BUYTICKETPanel)
    BUYTICKETPanel.show()
    sys.exit(app.exec_())

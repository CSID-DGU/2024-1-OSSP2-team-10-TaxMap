import React, { useEffect, useState } from "react";
import Nav from "../../components/Nav/Nav";
import Footer from "../../components/Footer/Footer";
import MapContent from "../../components/MapContent/MapContent";
import { useLocation, useParams } from "react-router-dom"; // 리액트 쿼리 스트링 읽어오기

// MapPage.jsx
function MapPage() {
  // 쿼리 스트링 읽어오기
  const { mode } = useParams(); // service 또는 department 읽어옴

  // 사용자가 선택한 장소의 좌표를 중심좌표로 하여 지도 보여줌
  const location = useLocation(); // 위치 정보 가져오기

  // url state에서 좌표 정보 추출
  const coordinates = location.state?.coordinates || {
    lat: 37.55805491922956,
    lng: 126.99832780535394, // 동국대 신공학관
  };

  // 쿼리 스트링에서 부처 카테고리 추출
  const searchParams = new URLSearchParams(location.search);
  const initialDepartment = searchParams.get("category");

  // 부처 선택 상태 관리
  const [selectedDepartment, setSelectedDepartment] =
    useState(initialDepartment);

  return (
    <div>
      <Nav onDepartmentSelect={setSelectedDepartment} />
      {/*!-- 서비스 모드, 부처별 모드로 쿼리 스트링 전달하여 MapPage로 라우터 연결까지만 완료 --*/}

      <MapContent
        coordinates={coordinates}
        selectedDepartment={selectedDepartment}
      />
      <Footer />
    </div>
  );
}
export default MapPage;
